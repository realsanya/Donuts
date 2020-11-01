package repositories;

import models.Order;
import models.Product;
import models.User;
import repositories.interfaces.OrderRepository;
import repositories.interfaces.RowMapper;
import services.interfaces.ProductService;
import services.interfaces.UserService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static repositories.ProductRepositoryJdbc.productRowMapper2;

public class OrderRepositoryJdbc implements OrderRepository {

    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private UserService userService;
    private ProductService productService;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO order_table (user_id) VALUES (?);";

    //language=SQL
    private static final String SQL_ADD_PRODUCT = "INSERT INTO customer_order (order_id, product_id) VALUES (?, ?);";

    //language=SQL
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM customer_order WHERE order_id=? AND product_id=?";

    //language=SQL
    private static final String SQL_GET_PRODUCTS = "SELECT product_id FROM customer_order WHERE order_id =?";


    //language=SQL
    private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM order_table where (user_id) = ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM order_table WHERE order_id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM order_table";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM order_table WHERE user_id= ? ";


    private RowMapper<Order> orderRowMapper = row -> Order.builder()
            .order_id(row.getInt("order_id"))
            .user_id(userService.getUserById(row.getInt("user_id")))
            .products_id(productsInOrder(row.getInt("order_id")))
            .total_price(row.getFloat("total_price"))
            .build();

    private List<Product> productsInOrder(Integer id) {
        List<Product> products = template.query(SQL_GET_PRODUCTS, productRowMapper2, id);
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            result.add(productService.getProductById(p.getId()));
        }
        return !result.isEmpty() ? result : new ArrayList<>();
    }

    public OrderRepositoryJdbc(DataSource dataSource, UserService userService, ProductService productService) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.productService = productService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    public List<Product> findProducts(Order order) {
        return productsInOrder(order.getOrder_id());
    }

    @Override
    public List<Order> findAll() {
        return template.query(SQL_SELECT_ALL, orderRowMapper);
    }

    @Override
    public Order findById(Integer id) {
        List<Order> orders = template.query(SQL_SELECT_BY_ID, orderRowMapper, id);
        return !orders.isEmpty() ? orders.get(0) : null;
    }

    @Override
    public void save(Order order) {
        template.queryInsert(SQL_CREATE, order.getUser_id().getId());
    }

    @Override
    public Order getUserOrder(User user) {
        List<Order> baskets = template.query(SQL_FIND_BY_USER_ID, orderRowMapper, user.getId());
        return !baskets.isEmpty() ? baskets.get(0) : null;
    }


    @Override
    public void addProduct(Order order, Product product) {
        template.queryInsert(SQL_ADD_PRODUCT, order.getOrder_id(), product.getId());
    }

    @Override
    public void deleteProduct(Order order, Product product) {
        template.queryInsert(SQL_DELETE_PRODUCT, order.getOrder_id(), product.getId());
    }
}

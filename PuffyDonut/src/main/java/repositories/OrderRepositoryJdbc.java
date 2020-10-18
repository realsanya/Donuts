package repositories;

import models.Order;
import models.Product;
import models.User;
import services.UserService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static repositories.ProductRepositoryJdbc.productRowMapper;

public class OrderRepositoryJdbc implements OrderRepository {

    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private UserService userService;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO order_table (user_id) VALUES (?);";

    //language=SQL
    private static final String SQL_ADD_PRODUCT = "INSERT INTO order_table (order_id, product_id) VALUES (?, ?);";

    //language=SQL
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM order_table WHERE order_id=? AND product_id=?";

    //TODO
    //language=SQL
    private static final String SQL_GET_PRODUCTS = "SELECT p.product_id, p.product_name, p.product_description, p.quantity, p.price, p.image, c.name as ca_name FROM customer_basket inner join basket b on b.id = customer_basket.basket_id inner join product p on p.id = customer_basket.product_id inner join categories c on c.id = p.category_id where basket_id=?;";


    //language=SQL
    private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM order_table where user_id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM order_table WHERE order_id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM order_table";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM order_table WHERE user_id= ? ";

    private RowMapper<Order> orderRowMapper = row -> Order.builder()
            .order_id(row.getLong("product_id"))
            .user_id(userService.getUserById(row.getLong("user_id")))
            .products_id(productsInBasket(row.getInt("id")))
            .total_price(row.getFloat("total_price"))
            .payment(row.getInt("payment"))
            .build();

    private List<Product> productsInBasket(int id) {
        List<Product> products = template.query(SQL_GET_PRODUCTS, productRowMapper, id);
        return !products.isEmpty() ? products : new ArrayList<>();
    }

    public OrderRepositoryJdbc(DataSource dataSource, UserService userService) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<Order> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, orderRowMapper);
    }

    @Override
    public Optional<Order> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Order> orders = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, orderRowMapper, id);
        return Optional.ofNullable(orders.get(0));
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

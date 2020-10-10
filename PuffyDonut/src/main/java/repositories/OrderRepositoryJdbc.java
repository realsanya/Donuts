package repositories;

import models.Order;
import models.Review;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryJdbc implements OrderRepository {

    private DataSource dataSource;

    //language=SQL
    final String SQL_INSERT_ORDER = "INSERT INTO order_table ( user_id, product_id, total_price, payment ) VALUES (?, ?, ?, ?)";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM order_table WHERE id=";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM order_table";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM order_table WHERE user_id= ";

    private RowMapper<Order> orderRowMapper = row -> Order.builder()
            .user_id(row.getLong("user_id"))
            .order_id(row.getLong("product_id"))
            .total_price(row.getFloat("total_price"))
            .payment(row.getInt("payment"))
            .build();

    public OrderRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Order> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, orderRowMapper);
    }

    @Override
    public List<Order> findAllByUserID(Long user_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Order> orders = simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, orderRowMapper, user_id);
        return orders;
    }

    @Override
    public Optional<Order> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Order> orders = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, orderRowMapper, id);
        return Optional.ofNullable(orders.get(0));
    }

    //TODO
    @Override
    public void save(Order entity) {

    }

    @Override
    public void update(Order entity) {

    }
}

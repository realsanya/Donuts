package repositories;

import models.Delivery;
import models.Order;
import services.OrderService;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class DeliveryRepositoryJdbc implements DeliveryRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private OrderService orderService;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM delivery";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM delivery WHERE id= ?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO delivery (order_id, delivery_date, delivery_status) VALUES (?, ?, ?);";

    private RowMapper<Delivery> deliveryRowMapper = row -> Delivery.builder()
            .order_id(orderService.getOrderById(row.getLong("order_id")))
            .delivery_date(row.getDate("delivery_date"))
            .delivery_status(row.getString("delivery_status"))
            .build();

    public DeliveryRepositoryJdbc(DataSource dataSource, OrderService orderService) {
        this.dataSource = dataSource;
        this.orderService = orderService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<Delivery> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, deliveryRowMapper);
    }

    @Override
    public Delivery findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Delivery> deliveries = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, deliveryRowMapper, id);
        return !deliveries.isEmpty() ? deliveries.get(0) : null;
    }

    //TODO
    @Override
    public void save(Delivery delivery) {
        template.queryInsert(SQL_CREATE, delivery);
    }

}

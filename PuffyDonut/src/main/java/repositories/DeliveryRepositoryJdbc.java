package repositories;

import models.Comment;
import models.Delivery;
import models.Donut;
import models.Review;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class DeliveryRepositoryJdbc implements DeliveryRepository {
    private DataSource dataSource;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM delivery";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM comment WHERE id= ";

    private RowMapper<Delivery> deliveryRowMapper = row -> Delivery.builder()
            .order_id(row.getLong("order_id"))
            .delivery_date(row.getDate("delivery_date"))
            .delivery_status(row.getString("delivery_status"))
            .build();

    public DeliveryRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Delivery> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, deliveryRowMapper);
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Delivery> deliveries = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, deliveryRowMapper, id);
        return Optional.ofNullable(deliveries.get(0));
    }

    //TODO
    @Override
    public void save(Delivery entity) {

    }

    @Override
    public void update(Delivery entity) {

    }
}

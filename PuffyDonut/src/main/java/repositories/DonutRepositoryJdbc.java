package repositories;

import models.Donut;
import models.Review;
import models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DonutRepositoryJdbc implements DonutRepository {
    private DataSource dataSource;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM product";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_WEIGHT = "SELECT * FROM product WHERE weight= ";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_TAG = "SELECT * FROM product WHERE tag= ";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM product WHERE id= ";

    public DonutRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private RowMapper<Donut> donutRowMapper = row -> Donut.builder()
            .name(row.getString("product_name"))
            .description(row.getString("product_description"))
            .image(row.getString("image"))
            .price(row.getFloat("price"))
            .availability(row.getBoolean("availability"))
            .quantity(row.getInt("quantity"))
            .weight(row.getInt("weight"))
            .tag(row.getString("tag"))
            .build();


    public List<Donut> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, donutRowMapper);
    }

    public List<Donut> findAllByTag(String tag) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_TAG, donutRowMapper, tag);
    }

    public Optional<Donut> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Donut> donuts = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, donutRowMapper, id);
        return Optional.ofNullable(donuts.get(0));
    }

    public List<Donut> findAllByWeight(Integer weight) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_WEIGHT, donutRowMapper, weight);
    }


//TODO
    public void save(Donut entity) {
        throw new IllegalStateException();
    }

    public void update(Donut entity) {
        throw new IllegalStateException();
    }
}

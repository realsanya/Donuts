package repositories;

import models.Comment;
import models.Review;
import models.User;
import services.UserService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewRepositoryJdbc implements ReviewRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private UserService userService;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO review ( user_id, review_text, date ) VALUES (?, ?, ?)";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM review";


    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM review WHERE id= ";


    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM review WHERE user_id= ";


    private RowMapper<Review> reviewRowMapper = row -> Review.builder()
            .user_id(userService.getUserById(row.getLong("user_id")))
            .text(row.getString("review_text"))
            .date(row.getDate("date"))
            .build();

    public ReviewRepositoryJdbc(DataSource dataSource, UserService userService) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Review review) {
        template.queryInsert(SQL_CREATE, review);
    }

    @Override
    public List<Review> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, reviewRowMapper);
    }

    @Override
    public Review findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Review> reviews = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, reviewRowMapper, id);
        return !reviews.isEmpty() ? reviews.get(0) : null;
    }

    @Override
    public List<Review> findAllByUserID(User user_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, reviewRowMapper, user_id);
    }

}

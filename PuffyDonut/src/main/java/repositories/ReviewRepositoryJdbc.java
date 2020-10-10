package repositories;

import models.Review;
import models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewRepositoryJdbc implements ReviewRepository {
    private DataSource dataSource;

    //language=SQL
    final String SQL_INSERT_REVIEW = "INSERT INTO review ( user_id, review_text, date ) VALUES (?, ?, ?)";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM review WHERE id= ";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM review";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM review WHERE user_id= ";


    private RowMapper<Review> reviewRowMapper = row -> Review.builder()
            .user_id(row.getLong("user_id"))
            .text(row.getString("review_text"))
            .date(row.getDate("date"))
            .build();

    public ReviewRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Review> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, reviewRowMapper);
    }

    @Override
    public Optional<Review> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Review> reviews = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, reviewRowMapper, id);
        return Optional.ofNullable(reviews.get(0));
    }

    @Override
    public List<Review> findAllByUserID(Long user_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Review> reviews = simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, reviewRowMapper, user_id);
        return reviews;
    }

    //TODO
    @Override
    public void save(Review review) {
//        try {
//            Connection connection = DBConnection.createConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_REVIEW);
//            preparedStatement.setLong(1, review.getUser_id());
//            preparedStatement.setString(2, review.getText());
//            preparedStatement.setDate(3, review.getDate());
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
    }

    @Override
    public void update(Review entity) {

    }

}

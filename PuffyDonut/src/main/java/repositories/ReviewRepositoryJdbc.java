package repositories;

import models.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryJdbc implements ReviewRepository {
    final String SQL_INSERT_REVIEW = "INSERT INTO review ( user_id, review_text, date ) VALUES (?, ?, ?);";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM review WHERE id= ";
    private final String SQL_SELECT_ALL = "SELECT * FROM review";
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM review WHERE user_id= ";

    @Override
    public List<Review> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL);

            List<Review> result = new ArrayList<>();

            while (resultSet.next()) {
                Review review = Review.builder().id(resultSet.getLong("id"))
                        .user_id(resultSet.getLong("user_id"))
                        .text(resultSet.getString("review_text"))
                        .date(resultSet.getDate("date")).build();
                result.add(review);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public Review findById(Long id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            if (resultSet.next()) {
                return new Review(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }

    @Override
    public void save(Review review) {
        try {
            Connection connection = DBConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_REVIEW);
            preparedStatement.setLong(1, review.getUser_id());
            preparedStatement.setString(2, review.getText());
            preparedStatement.setDate(3, review.getDate());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Review entity) {

    }

    @SuppressWarnings("TryFinallyCanBeTryWithResources")
    @Override
    public List<Review> findAllByUserID(int user_id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_BY_USER_ID + user_id);

            List<Review> result = new ArrayList<>();

            while (resultSet.next()) {
                Review review = Review.builder().id(resultSet.getLong("id"))
                        .user_id(resultSet.getLong("user_id"))
                        .text(resultSet.getString("review_text"))
                        .date(resultSet.getDate("date")).build();
                result.add(review);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }
}

package models.repositories;

import models.entities.Donut;
import models.entities.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryJdbc implements ReviewRepository {
    final String SQL_INSERT_REVIEW = "INSERT INTO review ( review_text ) VALUES (?);";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM review WHERE id= ";
    private final String SQL_SELECT_ALL = "SELECT * FROM review";

    @Override
    public List<Review> findAll() {
        ArrayList<Review> reviews = new ArrayList<Review>();
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            if (resultSet.next()) {
                reviews.add(new Review(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return reviews;
    }

    @Override
    public Review findById(Long id) {
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            if (resultSet.next()) {
                return new Review(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }

    @Override
    public void save(Review entity) {

    }

    @Override
    public void update(Review entity) {

    }
}

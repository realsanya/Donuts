package repositories;

import models.Donut;
import models.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DonutRepositoryJdbc implements DonutRepository {
    private final String SQL_SELECT_BY_ID = "SELECT * FROM product WHERE id= ";
    private final String SQL_SELECT_ALL = "SELECT * FROM product";
    private final String SQL_SELECT_ALL_BY_WEIGHT = "SELECT * FROM product WHERE weight= ";
    private final String SQL_SELECT_ALL_BY_TAG = "SELECT * FROM product WHERE tag= ";

    public Optional<Review> findById(Long id) {
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            if (resultSet.next()) {
                return new Donut(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }

    public List<Donut> findAll() {
        ArrayList<Donut> donuts = new ArrayList<Donut>();
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            if (resultSet.next()) {
                donuts.add(new Donut(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return donuts;
    }

    public List<Donut> findAllByTag(String tag) {
        ArrayList<Donut> donuts = new ArrayList<Donut>();
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BY_TAG + tag);

            if (resultSet.next()) {
                donuts.add(new Donut(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return donuts;
    }

    public List<Donut> findAllByWeight(int weight) {
        ArrayList<Donut> donuts = new ArrayList<Donut>();
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BY_WEIGHT + weight);

            if (resultSet.next()) {
                donuts.add(new Donut(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return donuts;
    }

    public void save(Donut entity) {
        throw new IllegalStateException();
    }

    public void update(Donut entity) {
        throw new IllegalStateException();
    }
}

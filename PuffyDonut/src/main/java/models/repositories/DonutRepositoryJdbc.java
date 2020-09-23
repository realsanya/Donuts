package models.repositories;

import models.entities.Donut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonutRepositoryJdbc implements DonutRepository {
    private final String SQL_SELECT_ALL = "SELECT * FROM user";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM donut WHERE id= ";
    private Connection connection;

    public DonutRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }


    public List<Donut> findAllByTag(String tag) {
        return null;
    }

    public List<Donut> findAllByWeight(int weight) {
        return null;
    }

    public List<Donut> findAll() {
        ArrayList<Donut> donuts = new ArrayList<Donut>();
        try {
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

    public Donut findById(Long id) {
        try {
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

    public void save(Donut entity) {
        //TODO запрос к бд пересмотреть
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO product (product_name, product_description, image, " +
                            "price, availability,quantity, weight, tag) VALUES ('%s','%s','%s','%d', '%s', '%d', '%d', '%s')");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(Donut entity) {
        //TODO запрос к бд пересмотреть
        try {
            Statement statement = connection.createStatement();
//            statement.execute("ALTER TABLE product" + " product_name = " + entity.product_name() +
//                    ", last_name = " + entity.getLastName() + ", age = " + entity.getAge() +
//                    ", group_number = " + entity.getGroupNumber() +
//                    " WHERE id = " + entity.getId() + "");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}

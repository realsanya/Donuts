package models.repositories;

import models.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    final String INSERT_USERS_SQL = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, username, password, email) VALUES" + "(?, ? , ? , ? , ? , ? );";
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "realsanya";
    int result = 0;


    public List<User> findAll() {
        return null;
    }

    public User findById(Long id) {
        return null;
    }

    public void save(User user) {
        try {
//            String first_name = user.getFirst_name();
//            String last_name = user.getLast_name();
//            String address = user.getAddress();
//            String username = user.getUsername();
//            String password = user.getPassword();
//            String email = user.getEmail();


            Connection connection = DBConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getEmail());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }


    }

    public void update(User entity) {

    }
}

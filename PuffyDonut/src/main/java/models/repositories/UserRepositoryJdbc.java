package models.repositories;

import models.entities.User;

import java.sql.*;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    final String INSERT_USERS_SQL = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, password, email) VALUES" + "(?, ? , ? , ? , ? );";
    private static final String URL = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC";
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
            Connection connection = DBConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(User entity) {
    }

    public String authenticateUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        String emailDB = "";
        String passwordDB = "";

        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT email,password FROM user_table");

            while (resultSet.next()) {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");

                if (email.equals(emailDB) && password.equals(passwordDB)) {
                    return "SUCCESS";
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return "Invalid user credentials";
    }


}

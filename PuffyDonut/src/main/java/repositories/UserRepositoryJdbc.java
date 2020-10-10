package repositories;

import models.Review;
import models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbc implements UserRepository {

    private DataSource dataSource;

    //language=SQL
    private final String SQL_INSERT_USERS = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, password, email) VALUES" + "(?, ? , ? , ? , ? );";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user_table";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_table WHERE user_id =";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL_PASS = "SELECT * FROM user_table WHERE email= ? AND password= ?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image(row.getString(row.getString("image")))
            .build();

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    public Optional<User> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<User> user = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, userRowMapper, id);
        return Optional.ofNullable(user.get(0));
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<User> user = simpleJdbcTemplate.query(SQL_SELECT_BY_EMAIL_PASS, userRowMapper, email, password);
        return Optional.ofNullable(user.get(0));
    }





//TODO
    public void save(User user) {
//        try {
//            Connection connection = DBConnection.createConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USERS);
//            preparedStatement.setString(1, user.getFirst_name());
//            preparedStatement.setString(2, user.getLast_name());
//            preparedStatement.setString(3, user.getAddress());
//            preparedStatement.setString(4, user.getPassword());
//            preparedStatement.setString(5, user.getEmail());
//
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
    }

    public void update(User entity) {
        throw new IllegalStateException();
    }

    public String authenticateUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        String emailDB = "";
        String passwordDB = "";

//        try {
//            Connection connection = DBConnection.createConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT email,password FROM user_table");
//
//            while (resultSet.next()) {
//                emailDB = resultSet.getString("email");
//                passwordDB = resultSet.getString("password");
//
//                if (email.equals(emailDB) && password.equals(passwordDB)) {
//                    return "SUCCESS";
//                }
//            }
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
        return "Invalid user credentials";
    }


}

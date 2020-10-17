package repositories;

import models.Review;
import models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbc implements UserRepository {

    private DataSource dataSource;

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //language=SQL
    private final String SQL_INSERT_USERS = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, password, email) VALUES" + "(?, ? , ? , ? , ? );";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user_table";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_table WHERE user_id =";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user_table WHERE email= ?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image(row.getString(row.getString("image")))
            .build();

    private RowMapper<User> userRowMapper2 = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();


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
    public Optional<User> findByEmail(String email) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<User> user = simpleJdbcTemplate.query(SQL_SELECT_BY_EMAIL, userRowMapper2, email);
        return Optional.ofNullable(user.get(0));
    }


    //TODO
    public void save(User user) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        simpleJdbcTemplate.queryInsert(SQL_INSERT_USERS,
                user.getFirst_name(),
                user.getLast_name(),
                user.getAddress(),
                user.getPassword(),
                user.getEmail());
    }

    //откроешь сайт с регистором пожалуйста
    public void update(User entity) {
        throw new IllegalStateException();
    }

//    public String authenticateUser(User user) {
//        String email = user.getEmail();
//        String password = user.getPassword();
//
//        String emailDB = "";
//        String passwordDB = "";
//
////        try {
////            Connection connection = DBConnection.createConnection();
////            Statement statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery("SELECT email,password FROM user_table");
////
////            while (resultSet.next()) {
////                emailDB = resultSet.getString("email");
////                passwordDB = resultSet.getString("password");
////
////                if (email.equals(emailDB) && password.equals(passwordDB)) {
////                    return "SUCCESS";
////                }
////            }
////        } catch (SQLException e) {
////            throw new IllegalStateException(e);
////        }
//        return "Invalid user credentials";
//    }

}

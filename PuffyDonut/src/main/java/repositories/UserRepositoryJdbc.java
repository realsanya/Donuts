package repositories;

import models.User;
import repositories.interfaces.RowMapper;
import repositories.interfaces.UserRepository;

import javax.sql.DataSource;
import java.util.List;


public class UserRepositoryJdbc implements UserRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    //language=SQL
    private final String SQL_INSERT_USERS = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, password, email, image) VALUES" + "( ?, ? , ? , ? , ?, ?);";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user_table";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_table WHERE user_id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user_table WHERE email= ?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    private RowMapper<User> userRowMapper2 = row -> User.builder()
            .id(row.getLong("user_id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();


    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }

    public User findById(Integer id) {
        List<User> users = template.query(SQL_SELECT_BY_ID, userRowMapper, id);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = template.query(SQL_SELECT_BY_EMAIL, userRowMapper2, email);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public void save(User user) {
        template.queryInsert(SQL_INSERT_USERS,
                user.getFirst_name(),
                user.getLast_name(),
                user.getAddress(),
                user.getPassword(),
                user.getEmail(),
                user.getImage());
    }

}

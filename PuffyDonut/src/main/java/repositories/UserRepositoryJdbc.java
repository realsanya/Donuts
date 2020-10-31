package repositories;

import models.Image;
import models.User;
import repositories.interfaces.RowMapper;
import repositories.interfaces.UserRepository;
import services.interfaces.ImageService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryJdbc implements UserRepository {

    private DataSource dataSource;
    private SimpleJdbcTemplate template;
    private ImageService imageService;

    public UserRepositoryJdbc(DataSource dataSource, ImageService imageService) {
        this.dataSource = dataSource;
        this.imageService = imageService;
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

    //language=SQL
    private final String SQL_UPDATE_IMAGE = "UPDATE user_table SET image=? WHERE user_id =?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image(imageService.getById(row.getInt("image")))
            .build();

    private RowMapper<User> userRowMapper2 = row -> User.builder()
            .id(row.getLong("user_id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image(imageService.getById(row.getInt("image")))
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
    public void update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_IMAGE);
            statement.executeUpdate("UPDATE user_table SET image=" + user.getImage().getId() + " WHERE user_id=" + user.getId());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void save(User user) {
        template.queryInsert(SQL_INSERT_USERS,
                user.getFirst_name(),
                user.getLast_name(),
                user.getAddress(),
                user.getPassword(),
                user.getEmail(),
                user.getImage().getId());
    }

}

package repositories;

import models.Comment;
import models.Product;
import models.User;
import repositories.interfaces.CommentRepository;
import repositories.interfaces.RowMapper;
import services.interfaces.ProductService;
import services.interfaces.UserService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommentRepositoryJdbc implements CommentRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private UserService userService;
    private ProductService productService;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO comment" + "( user_id, donut_id, date, text) VALUES (?, ? , ?, ?)";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM comment";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM comment WHERE id = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM comment WHERE user_id = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_PRODUCT_ID = "SELECT * FROM comment WHERE donut_id= ?";

    private RowMapper<Comment> commentRowMapper = row -> Comment.builder()
            .user_id(userService.getUserById(row.getInt("user_id")))
            .product_id(productService.getProductById(row.getInt("donut_id")))
            .text(row.getString("text"))
            .date(row.getDate("date"))
            .build();

    public CommentRepositoryJdbc(DataSource dataSource, UserService userService, ProductService productService) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.productService = productService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Comment comment) {
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_CREATE)) {
            statement.setObject(1, comment.getUser_id().getId());
            statement.setObject(2, comment.getProduct_id().getId());
            statement.setObject(3, comment.getDate());
            statement.setObject(4, comment.getText());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
//        template.queryInsert(SQL_CREATE, comment);
    }

    @Override
    public List<Comment> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, commentRowMapper);
    }

    @Override
    public Comment findById(Integer id) {
        List<Comment> comments = template.query(SQL_SELECT_BY_ID, commentRowMapper, id);
        return !comments.isEmpty() ? comments.get(0) : null;
    }

    @Override
    public List<Comment> findAllByUserID(User user_id) {
        List<Comment> comments = template.query(SQL_SELECT_ALL_BY_USER_ID, commentRowMapper, user_id.getId());
        return !comments.isEmpty() ? comments : null;
    }

    @Override
    public List<Comment> findAllByProductID(Product product_id) {
        List<Comment> comments = template.query(SQL_SELECT_ALL_BY_PRODUCT_ID, commentRowMapper, product_id.getId());
        return !comments.isEmpty() ? comments : null;
    }
}

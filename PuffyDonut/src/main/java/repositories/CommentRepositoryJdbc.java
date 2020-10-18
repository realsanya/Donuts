package repositories;

import models.Comment;
import models.Order;
import models.Product;
import models.User;
import services.ProductService;
import services.UserService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CommentRepositoryJdbc implements CommentRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;
    private UserService userService;
    private ProductService productService;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO comment" + "( text, user_id, date) VALUES (?, ? , ?)";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM comment";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM comment WHERE id = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM comment WHERE user_id = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_PRODUCT_ID = "SELECT * FROM comment WHERE donut_id= ?";

    private RowMapper<Comment> commentRowMapper = row -> Comment.builder()
            .user_id(userService.getUserById(row.getLong("user_id")))
            .product_id(productService.getProductById(row.getLong("donut_id")))
            .text(row.getString("text"))
            .date(row.getDate("date"))
            .build();

    public CommentRepositoryJdbc(DataSource dataSource, UserService userService, ProductService productService) {

        this.dataSource = dataSource;
        this.userService = userService;
        this.productService = productService;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    //TODO
    @Override
    public void save(Comment comment) {
        template.queryInsert(SQL_CREATE, comment);
    }

    @Override
    public List<Comment> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, commentRowMapper);
    }

    @Override
    public Comment findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Comment> comments = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, commentRowMapper, id);
        return !comments.isEmpty() ? comments.get(0) : null;
    }

    @Override
    public List<Comment> findAllByUserID(User user_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, commentRowMapper, user_id);
    }

    @Override
    public List<Comment> findAllByProductID(Product product_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_PRODUCT_ID, commentRowMapper, product_id);
    }
}

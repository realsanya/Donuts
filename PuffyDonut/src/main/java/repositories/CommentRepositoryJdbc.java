package repositories;

import models.Comment;
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
    final String SQL_INSERT_COMMENTS = "INSERT INTO comment" + "( text, user_id," +
            "date) VALUES" + "(?, ? , ?)";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM comment";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM comment WHERE id= ";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM comment WHERE user_id= ";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_DONUT_ID = "SELECT * FROM comment WHERE donut_id= ";

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
    }

    @Override
    public List<Comment> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, commentRowMapper);
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public List<Comment> findAllByUserID(User user_id) {
        return null;
    }

    @Override
    public List<Comment> findAllByProductID(Product product_id) {
        return null;
    }
}

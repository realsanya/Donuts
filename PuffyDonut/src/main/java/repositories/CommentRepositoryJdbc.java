package repositories;

import models.Comment;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CommentRepositoryJdbc implements CommentRepository {
    private DataSource dataSource;

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
            .user_id(row.getLong("user_id"))
            .donut_id(row.getLong("donut_id"))
            .text(row.getString("text"))
            .date(row.getDate("date"))
            .build();

    public CommentRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Comment> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, commentRowMapper);
    }

    @Override
    public List<Comment> findAllByUserID(Long user_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, commentRowMapper, user_id);
    }

    @Override
    public List<Comment> findAllByDonutID(Long donut_id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL_BY_DONUT_ID, commentRowMapper, donut_id);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Comment> comments = simpleJdbcTemplate.query(SQL_SELECT_BY_ID, commentRowMapper, id);
        return Optional.ofNullable(comments.get(0));
    }


    //TODO
    @Override
    public void save(Comment comment) {
    }

    @Override
    public void update(Comment entity) {
        throw new IllegalStateException();
    }

}

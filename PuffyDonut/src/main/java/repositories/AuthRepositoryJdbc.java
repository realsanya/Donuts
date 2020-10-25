package repositories;

import repositories.interfaces.AuthRepository;
import repositories.interfaces.RowMapper;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.util.List;

public class AuthRepositoryJdbc implements AuthRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO cookie (uuid) VALUES ?";

    //language=SQL
    final String SQL_FIND = "SELECT * FROM cookie WHERE uuid = ?";

    public AuthRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    public RowMapper<Cookie> cookieRowMapper = row -> new Cookie("cookie", row.getString("uuid"));

    @Override
    public void create(Cookie cookie) {
        template.queryInsert(SQL_CREATE, cookie.getValue());
    }

    @Override
    public boolean find(Cookie cookie) {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        List<Cookie> cookies = simpleJdbcTemplate.query(SQL_FIND, cookieRowMapper, cookie.getValue());
        return cookies != null;
    }
}

package repositories;

import models.Image;
import models.Order;
import models.Product;
import models.User;
import repositories.interfaces.ImageRepository;
import repositories.interfaces.RowMapper;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

public class ImageRepositoryJdbc implements ImageRepository {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM image";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM image WHERE id=?";

    //language=SQL
    private final String SQL_INSERT = "INSERT INTO image (type, path) VALUES (?, ?)";

    //language=SQL
    private final String SQL_SELECT_INSERT = "SELECT * from image WHERE `image`.id = LAST_INSERT_ID()";

    //language=SQL
    private final String SQL_SELECT_BY_PATH = "SELECT * FROM image WHERE path=?";

    private DataSource dataSource;
    private SimpleJdbcTemplate template;

    public ImageRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    private RowMapper<Image> imageRowMapper = row -> Image.builder()
            .id(row.getInt("id"))
            .type(row.getString("type"))
            .path(row.getString("path"))
            .build();

    private RowMapper<Image> imageRowMapper2 = row -> Image.builder()
            .type(row.getString("type"))
            .path(row.getString("path"))
            .build();


    @Override
    public List<Image> findAll() {
        return template.query(SQL_SELECT_ALL, imageRowMapper);
    }

    @Override
    public Image findById(Integer id) {
        List<Image> images = template.query(SQL_SELECT_BY_ID, imageRowMapper, id);
        return !images.isEmpty() ? images.get(0) : null;
    }

    @Override
    public void save(Image image) {
        template.queryInsert(SQL_INSERT, image.getType(), image.getPath());
    }

    @Override
    public Integer update(Image image) {
        save(image);
        List<Image> images = template.query(SQL_SELECT_INSERT, imageRowMapper);
        return !images.isEmpty() ? images.get(0).getId() : null;
    }

    @Override
    public Image findByPath(String path) {
        List<Image> images = template.query(SQL_SELECT_BY_PATH, imageRowMapper, path);
        return !images.isEmpty() ? images.get(0) : null;
    }
}

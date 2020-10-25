package repositories;

import models.Product;
import models.Tag;
import repositories.interfaces.ProductRepository;
import repositories.interfaces.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryJdbc implements ProductRepository {
    private final DataSource dataSource;
    private final SimpleJdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM product";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM product WHERE product_id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_TAG = "SELECT donut_id FROM tag_table WHERE tag= ?";

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM product WHERE product_name = ? ";

    //language=SQL
    private final String SQL_SELECT_BY_INCREASE_PRICE = "SELECT * FROM product ORDER BY price";

    //language=SQL
    private final String SQL_SELECT_BY_DECREASE_PRICE = "SELECT * FROM product ORDER BY price DESC";

    //language=SQL
    private final String SQL_SELECT_BY_INCREASE_WEIGHT = "SELECT * FROM product ORDER BY weight";

    //language=SQL
    private final String SQL_SELECT_BY_DECREASE_WEIGHT = "SELECT * FROM product ORDER BY weight DESC";


    public ProductRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    public static RowMapper<Product> productRowMapper = row -> Product.builder()
            .id(row.getLong("product_id"))
            .name(row.getString("product_name"))
            .description(row.getString("product_description"))
            .image(row.getString("image"))
            .price(row.getFloat("price"))
            .availability(row.getBoolean("availability"))
            .weight(row.getInt("weight"))
            .tag(Tag.builder().tag("tag").build())
            .build();

    @Override
    public void save(Product product) {
        throw new IllegalStateException("Error");
    }

    public List<Product> findAll() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        return simpleJdbcTemplate.query(SQL_SELECT_ALL, productRowMapper);
    }

    @Override
    public Product findById(Long id) {
        List<Product> products = template.query(SQL_SELECT_BY_ID, productRowMapper, id);
        return !products.isEmpty() ? products.get(0) : null;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> products = template.query(SQL_SELECT_BY_NAME, productRowMapper, name);
        return !products.isEmpty() ? products : null;
    }

    public static RowMapper<Tag> tagRowMapper = row -> Tag.builder()
            .id(Product.builder().id(row.getLong("donut_id")).build())
            .build();


    @Override
    public List<Product> findProductsByTag(String tag) {
        List<Tag> tags = template.query(SQL_SELECT_BY_TAG, tagRowMapper, tag);
        List<Product> products = new ArrayList<>();
        for (Tag t : tags) {
            products.add(t.getId());
        }
        return !products.isEmpty() ? products : null;
    }

    @Override
    public List<Product> findProductsByIncreasePrice() {
        List<Product> products = template.query(SQL_SELECT_BY_INCREASE_PRICE, productRowMapper);
        return !products.isEmpty() ? products : null;
    }

    @Override
    public List<Product> findProductsByDecreasePrice() {
        List<Product> products = template.query(SQL_SELECT_BY_DECREASE_PRICE, productRowMapper);
        return !products.isEmpty() ? products : null;
    }

    @Override
    public List<Product> findProductsByIncreaseWeight() {
        List<Product> products = template.query(SQL_SELECT_BY_INCREASE_WEIGHT, productRowMapper);
        return !products.isEmpty() ? products : null;
    }

    @Override
    public List<Product> findProductsByDecreaseWeight() {
        List<Product> products = template.query(SQL_SELECT_BY_DECREASE_WEIGHT, productRowMapper);
        return !products.isEmpty() ? products : null;
    }
}

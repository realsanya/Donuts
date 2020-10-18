package repositories;

import models.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryJdbc implements ProductRepository {
    private final DataSource dataSource;
    private final SimpleJdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM product";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM product WHERE product_id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_TAG = "SELECT * FROM product WHERE tag= ?";

    //language=SQL
    private final String SQL_SELECT_BY_PRICE = "SELECT * FROM product WHERE price= ?";

    //language=SQL
    private final String SQL_SELECT_BY_WEIGHT = "SELECT * FROM product WHERE weight = ? ";

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM product WHERE product_name = ? ";


    public ProductRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    public static RowMapper<Product> productRowMapper = row -> Product.builder()
            .name(row.getString("product_name"))
            .description(row.getString("product_description"))
            .image(row.getString("image"))
            .price(row.getFloat("price"))
            .availability(row.getBoolean("availability"))
            .quantity(row.getInt("quantity"))
            .weight(row.getInt("weight"))
            .tag(row.getString("tag"))
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
    public Product findProductByName(String name) {
        List<Product> products = template.query(SQL_SELECT_BY_NAME, productRowMapper, name);
        return !products.isEmpty() ? products.get(0) : null;
    }


    @Override
    public List<Product> findProductsByTag(String tag) {
        return orderProductsTag(tag, SQL_SELECT_BY_TAG);
    }

    @Override
    public List<Product> findProductsByPrice(Float price) {
        return orderProductsPrice(price, SQL_SELECT_BY_PRICE);
    }

    @Override
    public List<Product> findProductsByWeight(Integer weight) {
        return orderProductsWeight(weight, SQL_SELECT_BY_WEIGHT);
    }


    private List<Product> orderProductsTag(String tag, String SQL) {
        List<Product> products = template.query(SQL, productRowMapper, tag);
        return !products.isEmpty() ? products : null;
    }

    private List<Product> orderProductsPrice(Float price, String SQL) {
        List<Product> products = template.query(SQL, productRowMapper, price);
        return !products.isEmpty() ? products : null;
    }

    private List<Product> orderProductsWeight(Integer weight, String SQL) {
        List<Product> products = template.query(SQL, productRowMapper, weight);
        return !products.isEmpty() ? products : null;
    }

}

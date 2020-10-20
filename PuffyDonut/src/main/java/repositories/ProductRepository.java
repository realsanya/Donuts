package repositories;

import models.Product;

import java.util.List;

public interface ProductRepository extends OrmRepository<Product> {

    Product findProductByName(String name);

    List<Product> findProductsByTag(String tag);

    List<Product> findProductsByIncreasePrice();

    List<Product> findProductsByDecreasePrice();

    List<Product> findProductsByIncreaseWeight();

    List<Product> findProductsByDecreaseWeight();
}

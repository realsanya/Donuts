package repositories;

import models.Product;

import java.util.List;

public interface ProductRepository extends OrmRepository<Product> {

    Product findProductByName(String name);

    List<Product> findProductsByTag(String tag);

    List<Product> findProductsByPrice(Float price);

    List<Product> findProductsByWeight(Integer weight);
}

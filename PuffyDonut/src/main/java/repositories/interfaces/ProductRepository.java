package repositories.interfaces;

import models.Product;
import repositories.interfaces.OrmRepository;

import java.util.List;

public interface ProductRepository extends OrmRepository<Product> {

    List<Product> findProductByName(String name);

    List<Product> findProductsByTag(String tag);

    List<Product> findProductsByIncreasePrice();

    List<Product> findProductsByDecreasePrice();

    List<Product> findProductsByIncreaseWeight();

    List<Product> findProductsByDecreaseWeight();
}

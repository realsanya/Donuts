package services.interfaces;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getProductByName(String name);

    List<Product> getAllProducts();

    List<Product> getAllProductsByTag(String tag);

    List<Product> getAllProductsByIncreasePrice();

    List<Product> getAllProductsByDecreasePrice();

    List<Product> getAllProductsByIncreaseWeight();

    List<Product> getAllProductsByDecreaseWeight();

}

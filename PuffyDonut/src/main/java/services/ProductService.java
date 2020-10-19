package services;

import models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProductById(Long id);

    Product getProductByName(String name);

    List<Product> getAllProducts();

    List<Product> getAllProductsByTag(String tag);

    List<Product> getAllDonutsByPrice(Float price);

    List<Product> getAllDonutsByWeight(Integer weight);
}
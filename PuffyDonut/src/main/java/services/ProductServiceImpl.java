package services;

import models.Product;
import repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByTag(String tag) {
        List<Product> result = new ArrayList<>();

        List<Product> productsList = productRepository.findProductsByTag(tag);
        for (Product product : productsList) {
            result.add(productRepository.findById(product.getId()));
        }
        return result;
    }

    @Override
    public List<Product> getAllProductsByIncreasePrice() {
        return productRepository.findProductsByIncreasePrice();
    }

    @Override
    public List<Product> getAllProductsByDecreasePrice() {
        return productRepository.findProductsByDecreasePrice();
    }

    @Override
    public List<Product> getAllProductsByIncreaseWeight() {
        return productRepository.findProductsByIncreaseWeight();
    }

    @Override
    public List<Product> getAllProductsByDecreaseWeight() {
        return productRepository.findProductsByDecreaseWeight();
    }


}

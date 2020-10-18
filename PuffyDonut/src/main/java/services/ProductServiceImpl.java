package services;

import models.Product;
import repositories.ProductRepository;

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
    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByTag(String tag) {
        return productRepository.findProductsByTag(tag);
    }

    @Override
    public List<Product> getAllDonutsByPrice(Float price) {
        return productRepository.findProductsByPrice(price);
    }

    @Override
    public List<Product> getAllDonutsByWeight(Integer weight) {
        return productRepository.findProductsByWeight(weight);
    }
}

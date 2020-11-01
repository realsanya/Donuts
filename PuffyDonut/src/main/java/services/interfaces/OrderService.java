package services.interfaces;

import models.Order;
import models.Product;
import models.User;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);

    void createOrder(Order order);

    Order getUserOrder(User user);

    List<Product> getAllProductsInOrder(Order order);

    void addProductInOrder(Order order, Product product);

    void deleteProductFromOrder(Order order, Product product);


}

package services.interfaces;

import models.Order;
import models.Product;
import models.User;

public interface OrderService {
    Order getOrderById(Long id);

    void createOrder(Order order);

    Order getUserOrder(User user);

    void addProductInOrder(Order order, Product product);

    void deleteProductFromOrder(Order order, Product product);


}

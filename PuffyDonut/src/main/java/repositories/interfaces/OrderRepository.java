package repositories.interfaces;

import models.Order;
import models.Product;
import models.User;

import java.util.List;

public interface OrderRepository extends OrmRepository<Order> {
    Order getUserOrder(User user);

    List<Product> findProducts(Order order);

    void addProduct(Order order, Product product);

    void deleteProduct(Order order, Product product);
}

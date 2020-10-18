package repositories;

import models.Order;
import models.Product;
import models.User;

import java.util.List;

public interface OrderRepository extends OrmRepository<Order> {
    Order getUserOrder(User user);

    void addProduct(Order order, Product product);

    void deleteProduct(Order order, Product product);
}

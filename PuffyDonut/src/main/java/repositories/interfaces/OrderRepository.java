package repositories.interfaces;

import models.Order;
import models.Product;
import models.User;

public interface OrderRepository extends OrmRepository<Order> {
    Order getUserOrder(User user);

    void addProduct(Order order, Product product);

    void deleteProduct(Order order, Product product);
}

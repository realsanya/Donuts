package services;

import models.Order;
import models.Review;
import models.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrdersByUserID(Long user_id);

    boolean orderIsExist(Long order_id);

    void addOrder(Order order);
}

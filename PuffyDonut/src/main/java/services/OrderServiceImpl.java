package services;

import models.Order;
import repositories.OrderRepository;
import repositories.ReviewRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersByUserID(Long user_id) {
        return orderRepository.findAllByUserID(user_id);
    }

    @Override
    public boolean orderIsExist(Long order_id) {
        return orderRepository.findById(order_id).isPresent();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}

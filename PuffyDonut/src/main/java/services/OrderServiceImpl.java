package services;

import models.Order;
import models.Product;
import models.User;
import repositories.interfaces.OrderRepository;
import services.interfaces.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getUserOrder(User user) {
        return orderRepository.getUserOrder(user);
    }

    @Override
    public void addProductInOrder(Order order, Product product) {
        orderRepository.addProduct(order, product);
    }

    @Override
    public void deleteProductFromOrder(Order order, Product product) {
        orderRepository.deleteProduct(order, product);
    }
}

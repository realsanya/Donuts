package repositories;

import models.Order;
import models.Review;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryJdbc implements OrderRepository {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return null;
    }

    @Override
    public void save(Order entity) {

    }

    @Override
    public void update(Order entity) {

    }
}

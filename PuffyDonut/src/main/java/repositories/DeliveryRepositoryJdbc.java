package repositories;

import models.Delivery;
import models.Review;

import java.util.List;
import java.util.Optional;

public class DeliveryRepositoryJdbc implements DeliveryRepository {
    @Override
    public List<Delivery> findAll() {
        return null;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return null;
    }

    @Override
    public void save(Delivery entity) {

    }

    @Override
    public void update(Delivery entity) {

    }
}

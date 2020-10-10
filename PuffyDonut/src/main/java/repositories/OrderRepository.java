package repositories;

import models.Order;

import java.util.List;

public interface OrderRepository extends OrmRepository<Order> {
    List<Order> findAllByUserID(Long user_id);
}

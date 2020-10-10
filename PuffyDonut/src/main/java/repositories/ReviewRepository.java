package repositories;

import models.Donut;
import models.Review;

import java.util.List;

public interface ReviewRepository extends OrmRepository<Review> {
    List<Review> findAllByUserID(Long id);
}

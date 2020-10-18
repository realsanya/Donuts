package repositories;

import models.Review;
import models.User;

import java.util.List;

public interface ReviewRepository extends OrmRepository<Review> {
    List<Review> findAllByUserID(User id);
}

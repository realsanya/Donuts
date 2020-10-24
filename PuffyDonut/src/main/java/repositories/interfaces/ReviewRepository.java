package repositories.interfaces;

import models.Review;
import models.User;
import repositories.interfaces.OrmRepository;

import java.util.List;

public interface ReviewRepository extends OrmRepository<Review> {
    List<Review> findAllByUserID(User id);
    List<Review> findAll(int page, int size);
}

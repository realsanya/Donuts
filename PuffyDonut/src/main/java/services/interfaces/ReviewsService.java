package services.interfaces;

import models.Review;
import models.User;

import java.util.List;
import java.util.Optional;

public interface ReviewsService {

    List<Review> getAllReviews();

    List<Review> getAllReviewsByUserID(User user_id);

    void addReview(Review review);
}
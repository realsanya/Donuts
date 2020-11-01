package services.interfaces;

import models.Review;
import models.User;
import utils.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ReviewsService {

    List<Review> getAllReviews();

    List<ReviewDto> getAllReviews(int page, int size);

    List<Review> getAllReviewsByUserID(User user_id);

    void addReview(ReviewDto reviewDto);
}

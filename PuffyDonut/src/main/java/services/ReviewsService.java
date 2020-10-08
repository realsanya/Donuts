package services;

import models.Review;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllReviewsByUserID(int user_id);
}

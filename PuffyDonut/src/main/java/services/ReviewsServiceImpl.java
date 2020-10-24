package services;

import models.Review;
import models.User;
import repositories.interfaces.ReviewRepository;
import services.interfaces.ReviewsService;

import java.util.List;

public class ReviewsServiceImpl implements ReviewsService {

    private ReviewRepository reviewRepository;

    public ReviewsServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getAllReviewsByUserID(User user_id) {
        return reviewRepository.findAllByUserID(user_id);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }
}

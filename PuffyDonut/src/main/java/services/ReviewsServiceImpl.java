package services;

import models.Review;
import repositories.ReviewRepository;
import repositories.ReviewRepositoryJdbc;

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
    public List<Review> getAllReviewsByUserID(Long user_id) {
        return reviewRepository.findAllByUserID(user_id);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }
}
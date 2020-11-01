package services;

import models.Review;
import models.User;
import repositories.interfaces.ReviewRepository;
import services.interfaces.ReviewsService;
import utils.ReviewDto;

import java.util.List;

import static utils.ReviewDto.from;

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
    public List<ReviewDto> getAllReviews(int page, int size) {
        return from(reviewRepository.findAll(page, size));
    }

    @Override
    public List<Review> getAllReviewsByUserID(User user_id) {
        return reviewRepository.findAllByUserID(user_id);
    }

    @Override
    public void addReview(ReviewDto reviewDto) {
        reviewRepository.save(
                Review.builder()
                        .user_id(reviewDto.getUser())
                        .text(reviewDto.getText())
                        .date(reviewDto.getDate())
                        .build()
        );
    }
}

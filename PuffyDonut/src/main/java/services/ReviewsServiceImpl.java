package services;

import models.Review;
import repositories.ReviewRepositoryJdbc;

import java.util.List;

public class ReviewsServiceImpl implements ReviewsService {
    private ReviewRepositoryJdbc reviewRepositoryJdbc = new ReviewRepositoryJdbc();

    public ReviewsServiceImpl(ReviewRepositoryJdbc reviewRepositoryJdbc) {
        this.reviewRepositoryJdbc = reviewRepositoryJdbc;
    }

    @Override
    public List<Review> getAllReviewsByUserID(int user_id) {
        return reviewRepositoryJdbc.findAllByUserID(user_id);
    }
}

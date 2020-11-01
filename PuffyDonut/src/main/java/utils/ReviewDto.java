package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Review;
import models.User;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private User user;
    private String text;
    private Date date;

    public static ReviewDto from(Review review) {
        return ReviewDto.builder()
                .user(review.getUser_id())
                .text(review.getText())
                .date(review.getDate())
                .build();
    }

    public static List<ReviewDto> from(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewDto::from)
                .collect(Collectors.toList());
    }

}

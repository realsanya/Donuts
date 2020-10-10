package repositories;

import models.Comment;
import models.Review;

import java.util.List;

public interface CommentRepository extends OrmRepository<Comment> {
    List<Comment> findAllByUserID(Long user_id);

    List<Comment> findAllByDonutID(Long donut_id);
}

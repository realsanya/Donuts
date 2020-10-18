package repositories;

import models.Comment;
import models.Product;
import models.User;

import java.util.List;

public interface CommentRepository extends OrmRepository<Comment> {
    List<Comment> findAllByUserID(User user_id);

    List<Comment> findAllByProductID(Product product_id);
}

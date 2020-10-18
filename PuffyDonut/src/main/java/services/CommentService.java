package services;

import models.Comment;
import models.Product;
import models.User;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    List<Comment> getAllCommentsByUserID(User user_id);

    List<Comment> getAllCommentsByDonutID(Product product_id);

    void addComment(Comment comment);
}

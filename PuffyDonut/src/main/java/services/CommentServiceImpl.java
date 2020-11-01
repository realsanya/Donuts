package services;

import models.Comment;
import models.Product;
import models.User;
import repositories.interfaces.CommentRepository;
import services.interfaces.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByUserID(User user_id) {
        return commentRepository.findAllByUserID(user_id);
    }

    @Override
    public List<Comment> getAllCommentsByDonutID(Product product_id) {
        return commentRepository.findAllByProductID(product_id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}

package services;

import models.Comment;
import repositories.CommentRepository;
import repositories.ReviewRepository;

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
    public List<Comment> getAllCommentsByUserID(Long user_id) {
        return commentRepository.findAllByUserID(user_id);
    }

    @Override
    public List<Comment> getAllCommentsByDonutID(Long donut_id) {
        return commentRepository.findAllByDonutID(donut_id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}

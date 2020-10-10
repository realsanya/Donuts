package services;

import models.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    List<Comment> getAllCommentsByUserID(Long user_id);

    List<Comment> getAllCommentsByDonutID(Long donut_id);

    void addComment(Comment comment);
}

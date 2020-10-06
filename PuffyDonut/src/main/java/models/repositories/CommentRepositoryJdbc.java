package models.repositories;

import models.entities.Comment;

import java.util.List;

public class CommentRepositoryJdbc implements CommentRepository {
    final String SQL_INSERT_COMMENTS = "INSERT INTO comment" + "( text, user_id," +
            "date) VALUES" + "(?, ? , ?);";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM comment WHERE id= ";
    private final String SQL_SELECT_ALL = "SELECT * FROM comment";


    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public void save(Comment entity) {

    }

    @Override
    public void update(Comment entity) {

    }
}

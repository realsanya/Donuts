package models.repositories;

import models.entities.Comment;
import models.entities.Donut;

import java.sql.*;
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
        try {
            Connection connection = DBConnection.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            if (resultSet.next()) {
                return new Comment(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }

    @Override
    public void save(Comment comment) {
        try {
            Connection connection = DBConnection.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_COMMENTS);
            preparedStatement.setString(1, comment.getText());
            preparedStatement.setDate(2, comment.getDate());
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Comment entity) {
        throw new IllegalStateException();
    }
}

package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder
public class Review {
    private Long id;
    private Long user_id;
    private String text;
    private Date date;

    public Review(Long id, Long user_id, String text, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.date = date;
    }

    public Review(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            //TODO
//            this.user_id = resultSet.getInt("user_id");
            this.text = resultSet.getString("text");
            this.date = resultSet.getDate("date");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}

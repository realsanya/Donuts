package models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.ResultSet;

@Getter
@Setter
public class Comment {
    private int id;
    private User user_id;
    private Donut donut_id;
    private String text;
    private Date date;

    public Comment(int id, User user_id, Donut donut_id, String text, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.donut_id = donut_id;
        this.text = text;
        this.date = date;
    }

    public Comment(ResultSet resultSet) {
        //TODO
    }
}

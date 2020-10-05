package models.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Review {
    private int id;
    private User user_id;
    private String text;
    private Date date;

    public Review(int id, User user_id, String text, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public User getUser_id() {
        return user_id;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

}

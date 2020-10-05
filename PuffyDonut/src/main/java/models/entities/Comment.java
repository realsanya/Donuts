package models.entities;

import java.sql.Date;

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

    public int getId() {
        return id;
    }

    public User getUser_id() {
        return user_id;
    }

    public Donut getDonut_id() {
        return donut_id;
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

}

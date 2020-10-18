package models;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Comment {
    private int id;
    private User user_id;
    private Product product_id;
    private String text;
    private Date date;
}

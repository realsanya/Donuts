package models;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Review {
    private Long id;
    private User user_id;
    private String text;
    private Date date;
}

package models;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String address;
    private String password;
    private String email;
    @Builder.Default
    private String image = "default.png";
}

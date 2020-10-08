package models;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String address;
    private String password;
    private String email;

    public User() {

    }

    public User(Long id, String first_name, String last_name, String address,
                String password, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.password = password;
        this.email = email;
    }

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("user_id");
            this.first_name = resultSet.getString("first_name");
            this.last_name = resultSet.getString("last_name");
            this.address = resultSet.getString("address");
            this.password = resultSet.getString("password");
            this.email = resultSet.getString("email");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

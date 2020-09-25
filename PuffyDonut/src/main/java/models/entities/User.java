package models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String address;
    private String username;
    private String password;
    private String email;

    public User(){

    }

    public User(Long id, String first_name, String last_name, String address, String username,
                String password, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("user_id");
            this.first_name = resultSet.getString("first_name");
            this.last_name = resultSet.getString("last_name");
            this.address = resultSet.getString("address");
            this.username = resultSet.getString("username");
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }
}

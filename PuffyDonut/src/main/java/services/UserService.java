package services;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    boolean userIsExist(String email);

    void addUser(User user);
}

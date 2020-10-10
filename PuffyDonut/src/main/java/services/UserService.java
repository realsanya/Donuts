package services;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserByEmailAndPassword(String email, String password);

    boolean userIsExist(String email, String password);

    void addUser(User user);
}

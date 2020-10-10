package services;

import models.User;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean userIsExist(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}

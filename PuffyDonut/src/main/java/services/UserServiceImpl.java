package services;

import models.Image;
import models.User;
import repositories.interfaces.UserRepository;
import services.interfaces.UserService;

import java.util.List;

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
    public boolean userIsExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

}

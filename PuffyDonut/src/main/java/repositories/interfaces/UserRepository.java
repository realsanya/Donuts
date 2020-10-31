package repositories.interfaces;

import models.Image;
import models.User;
import repositories.interfaces.OrmRepository;

public interface UserRepository extends OrmRepository<User> {
    User findByEmail(String email);

    void update(User user);
}

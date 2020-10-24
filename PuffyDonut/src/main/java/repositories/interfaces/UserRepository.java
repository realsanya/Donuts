package repositories.interfaces;

import models.User;
import repositories.interfaces.OrmRepository;

public interface UserRepository extends OrmRepository<User> {
    User findByEmail(String email);
}

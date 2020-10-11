package repositories;

import models.User;

import java.util.Optional;

public interface UserRepository extends OrmRepository<User> {
    Optional<User> findByEmail(String email);
}

package repositories;

import java.util.List;
import java.util.Optional;

public interface OrmRepository<T> {
    List<T> findAll();
    Optional<T> findById(Long id);

    void save(T entity);
    void update(T entity);
}
package repositories;

import models.Review;

import java.util.List;
import java.util.Optional;

public interface OrmRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T entity);

}

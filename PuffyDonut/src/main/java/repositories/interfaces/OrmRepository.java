package repositories.interfaces;

import models.Review;

import java.util.List;
import java.util.Optional;

public interface OrmRepository<T> {
    List<T> findAll();
    T findById(Integer id);
    void save(T entity);

}

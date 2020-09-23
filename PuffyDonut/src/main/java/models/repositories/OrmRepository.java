package models.repositories;

import java.util.List;

public interface OrmRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T entity);

    void update(T entity);
}

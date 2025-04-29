package lesson41.example.dao;

import java.util.List;

public interface Dao<T> {

    T findById(Long id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(Long id);
}

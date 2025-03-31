package dao;

public interface Dao<T, E> {

    T save(E entity);

}
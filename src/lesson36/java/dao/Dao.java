package lesson36.java.dao;

public interface Dao<T, E> {

    T save(E entity);

}
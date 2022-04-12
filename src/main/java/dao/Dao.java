package dao;

public interface Dao<T> {
    void getId(T t, int id);

    void getAll(T t);

    void delete(T t, int id);

    void update(T t);

    void save(T t);
}

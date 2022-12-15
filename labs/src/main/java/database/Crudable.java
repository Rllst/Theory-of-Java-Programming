package database;

public interface Crudable<T>{
    boolean create(T t);
    T read(int id);
    boolean update(int id, T t);
    boolean delete(int id);
}

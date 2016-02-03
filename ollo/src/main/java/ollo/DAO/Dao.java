package ollo.dao;

/**
 * Created by dima on 02.02.2016.
 */
public interface Dao<T> {

    public T create(T object);
    public T read(int id);
    public T update(T object);
    public T delete(T object);

}

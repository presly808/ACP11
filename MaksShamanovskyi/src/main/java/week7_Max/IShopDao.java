package week7_Max;

import java.util.List;

public interface IShopDao<T> {

    boolean create(T t);
    boolean delete(T t);
    T update(T t);
    List<T> getAllNotebooks();
}

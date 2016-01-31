package ua.artcode.library.dao;

import ua.artcode.library.model.Book;

/**
 * Created by serhii on 23.01.16.
 */
public interface Dao<T> {

    T create(T book);
    boolean delete(T book);
    T update(T book);
    T findById(Object id);

}

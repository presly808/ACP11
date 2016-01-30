package ua.artcode.week7.jpa.service;

import ua.artcode.week7.jpa.model.Book;

import java.util.List;

/**
 * Created by serhii on 30.01.16.
 */
public interface AuthorService {

    String login(String name, String pass);

    List<Book> getBooks(int authorId);

    boolean addBook(Book book);


}

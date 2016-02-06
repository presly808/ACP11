package ua.artcode.library.service;

import ua.artcode.library.exception.NoBookFoundException;
import ua.artcode.library.model.Author;
import ua.artcode.library.model.Book;

import java.util.List;

/**
 * Created by serhii on 30.01.16.
 */
public interface AuthorService {

    String login(String name, String pass);

    Book getBookById(Integer id) throws NoBookFoundException;

    List<Book> getBooks(int authorId);

    boolean addBook(Book book);

    boolean addAuthor(Author author);


}

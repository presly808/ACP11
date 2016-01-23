package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.dao.BookDao;
import ua.artcode.week7.jpa.dao.Dao;
import ua.artcode.week7.jpa.model.Book;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by serhii on 23.01.16.
 */
public class TesDao {


    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        BookDao bookDao = new BookDao(factory);

        Book book = new Book();
        book.setId(2);
        bookDao.delete(book);


        List<Book> bookList = bookDao.getBooksByType(Book.BookType.IT);
        bookList.stream().forEach(System.out::println);

    }
}

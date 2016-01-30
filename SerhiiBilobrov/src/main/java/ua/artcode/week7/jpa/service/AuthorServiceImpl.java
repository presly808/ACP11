package ua.artcode.week7.jpa.service;

import org.hibernate.service.spi.InjectService;
import ua.artcode.week7.jpa.dao.BookDao;
import ua.artcode.week7.jpa.ioc.ForInject;
import ua.artcode.week7.jpa.model.Book;
import ua.artcode.week7.jpa.validator.Validator;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {


    private BookDao bookDao;

    private Validator<Book> validator;

    public AuthorServiceImpl() {
    }

    public AuthorServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String login(String name, String pass) {
        return null;
    }

    @Override
    public List<Book> getBooks(int authorId) {
        return null;
    }

    @Override
    public boolean addBook(Book book) {

        if(validator.isValid(book)){
            return false;
        }

        Book created = bookDao.create(book);
        return created != null;
    }
}

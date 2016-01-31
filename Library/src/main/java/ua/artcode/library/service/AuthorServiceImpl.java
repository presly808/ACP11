package ua.artcode.library.service;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.artcode.library.dao.BookDao;
import ua.artcode.library.model.Book;
import ua.artcode.library.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
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
        return Arrays.asList(new Book(), new Book());
    }

    @Override
    public boolean addBook(Book book) {

        /*if(validator.isValid(book)){
            return false;
        }*/

        Book created = bookDao.create(book);
        return created != null;
    }
}

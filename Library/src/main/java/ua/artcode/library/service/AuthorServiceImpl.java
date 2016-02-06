package ua.artcode.library.service;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.library.dao.AuthorDao;
import ua.artcode.library.dao.BookDao;
import ua.artcode.library.exception.NoBookFoundException;
import ua.artcode.library.model.Author;
import ua.artcode.library.model.Book;
import ua.artcode.library.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

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
    public Book getBookById(Integer id) throws NoBookFoundException {
        Book book = bookDao.findById(id);

        if(book == null){
            throw new NoBookFoundException("Book with id " + id + " was not found");
        }

        return book;

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

    @Override
    @Transactional
    public boolean addAuthor(Author author) {
        Author created = authorDao.create(author);
        return created.getId() != 0;
    }
}

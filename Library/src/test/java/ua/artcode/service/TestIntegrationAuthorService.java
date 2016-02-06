package ua.artcode.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.artcode.library.model.Author;
import ua.artcode.library.model.Book;
import ua.artcode.library.service.AuthorService;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class TestIntegrationAuthorService {

    @Autowired
    private AuthorService service;

    @Test
    public void addBook(){
        boolean res =
                service.addBook(
                        new Book("book1", Book.BookType.IT, "Kiev", new Date(),500));
        Assert.assertTrue(res);
    }

    @Test
    public void createUser(){
        Assert.assertTrue(service.addAuthor(new Author("Martin",30000,new Date())));
    }

}

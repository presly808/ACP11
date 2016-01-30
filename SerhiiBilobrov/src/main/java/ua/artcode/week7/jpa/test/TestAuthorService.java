package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.ioc.ServiceLocator;
import ua.artcode.week7.jpa.dao.BookDao;
import ua.artcode.week7.jpa.service.AuthorService;
import ua.artcode.week7.jpa.service.AuthorServiceImpl;

import javax.persistence.Persistence;

/**
 * Created by serhii on 30.01.16.
 */
public class TestAuthorService {


    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl(
                new BookDao(
                    Persistence.createEntityManagerFactory("hibernate-unit")));

        AuthorService authorService1 = (AuthorService) ServiceLocator.get("authorService");
    }
}

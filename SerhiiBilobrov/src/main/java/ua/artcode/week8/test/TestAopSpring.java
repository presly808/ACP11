package ua.artcode.week8.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.week7.jpa.model.Book;
import ua.artcode.week7.jpa.service.AuthorService;

import java.util.List;

/**
 * Created by serhii on 31.01.16.
 */
public class TestAopSpring {


    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("week8/ioc/app-xml-annot-context.xml");
        AuthorService authorService = applicationContext.getBean(AuthorService.class);
        List books = authorService.getBooks(-45);
        authorService.login("", "");



    }
}

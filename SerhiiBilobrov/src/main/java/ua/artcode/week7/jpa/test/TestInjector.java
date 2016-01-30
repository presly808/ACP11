package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.ioc.DependencyInjector;
import ua.artcode.week7.jpa.service.AuthorService;
import ua.artcode.week7.jpa.service.AuthorServiceImpl;

/**
 * Created by serhii on 30.01.16.
 */
public class TestInjector {


    public static void main(String[] args) {
        AuthorService service = new AuthorServiceImpl();
        DependencyInjector.doInjection(service);
    }
}

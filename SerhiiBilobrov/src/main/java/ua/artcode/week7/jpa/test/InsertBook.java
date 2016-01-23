package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by serhii on 23.01.16.
 */
public class InsertBook {

    public static void main(String[] args) {

        Book book = new Book("Java 8", Book.BookType.IT, "Kiev", new Date(), 500);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        factory.close();

    }
}

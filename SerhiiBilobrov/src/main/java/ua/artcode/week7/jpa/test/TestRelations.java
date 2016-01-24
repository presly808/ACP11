package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.model.Address;
import ua.artcode.week7.jpa.model.Author;
import ua.artcode.week7.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by serhii on 24.01.16.
 */
public class TestRelations {


    public static void main(String[] args) {
        Address address = new Address("Kiev", "Starokievskaya", "10");
        Author author = new Author("Serhii", 123.34, new Date());
        author.setAddress(address);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(author);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        factory.close();
    }
}

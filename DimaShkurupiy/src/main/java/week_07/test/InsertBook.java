package week_07.test;

import week_07.jpa.model.Book;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Dima on 23.01.2016.
 */
public class InsertBook {
    public static void main(String[] args) {

        Book book = new Book("JAVA jaBa","S.Bilobrov","KIev",1500, 5000,new Date(), Book.EType.DRAMA);

        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("hibernate-unit");

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

package ua.artcode.week7.jpa.dao;

import ua.artcode.week7.jpa.model.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Created by serhii on 23.01.16.
 */
public class BookDao implements Dao<Book> {

    private EntityManagerFactory factory;

    public BookDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Book create(Book book) {
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

        return book;
    }

    @Override
    public boolean delete(Book book) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        book = manager.find(Book.class,book.getId());

        try {
            transaction.begin();
            manager.remove(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book findById(Object id) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            Book book = manager.find(Book.class, id);
            return book;
        } finally {
            manager.close();
        }

    }

    public List<Book> getBooksByType(Book.BookType type){
        EntityManager manager = factory.createEntityManager();
        // JPQL - Java PErsistence Query Language (OOP + SQL)
        TypedQuery<Book> query = manager.createQuery("SELECT b FROM Book b WHERE b.type =:typeName", Book.class);
        query.setParameter("typeName", type);
        query.setMaxResults(20);
        query.setFirstResult(0);

        return query.getResultList();
    }
}

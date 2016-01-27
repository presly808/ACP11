package week7_Max;

import org.apache.log4j.Logger;
import week6_Max.model.NoteBook;

import javax.persistence.*;
import java.util.List;

public class ShopDao implements IShopDao<NoteBook> {
    private static final Logger LOGGER = Logger.getLogger(ShopDao.class);
    private EntityManagerFactory factory;

    public ShopDao() {
        factory = Persistence.createEntityManagerFactory("hibernate-shop");
    }

    @Override
    public boolean create(NoteBook noteBook) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(noteBook);
            transaction.commit();
            LOGGER.info("noteBook was saved");
        } catch (Exception e) {
            LOGGER.error("noteBook was not saved", e);
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public boolean delete(NoteBook noteBook) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        noteBook = manager.find(NoteBook.class, noteBook.getId());
        try {
            transaction.begin();
            manager.remove(noteBook);
            transaction.commit();
            LOGGER.info("noteBook was deleted");
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public NoteBook update(NoteBook noteBook) {
        return null;
    }

    @Override
    public List<NoteBook> getAllNotebooks(){
        EntityManager manager = factory.createEntityManager();
        TypedQuery<NoteBook> query = manager.createQuery("SELECT * FROM NoteBook n", NoteBook.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        return query.getResultList();
    }
}

package week7_Max;

import org.apache.log4j.Logger;
import week6_Max.model.*;


import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ShopDao implements IShopDao<NoteBook> {
    private static final Logger LOGGER = Logger.getLogger(ShopDao.class);
    private EntityManagerFactory factory;
    private Scanner scanner;

    public ShopDao() {
        factory = Persistence.createEntityManagerFactory("hibernate-shop");
        scanner = new Scanner(System.in);
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
        TypedQuery<NoteBook> query = manager.createQuery("SELECT n FROM NoteBook n", NoteBook.class);
        query.setMaxResults(20);
        query.setFirstResult(0);
        return query.getResultList();
    }

    public List getAllHardware(IHardware hardware){
        EntityManager manager = factory.createEntityManager();
        if(hardware instanceof Model){
            TypedQuery<Model> query = manager.createQuery("SELECT n FROM Model n", Model.class);
            return query.getResultList();
        }else if(hardware instanceof Proc){
            TypedQuery<Proc> query = manager.createQuery("SELECT n FROM Proc n", Proc.class);
            return query.getResultList();
        }else if(hardware instanceof Hdd){
            TypedQuery<Hdd> query = manager.createQuery("SELECT n FROM Hdd n", Hdd.class);
            return query.getResultList();
        }else if(hardware instanceof Memory){
            TypedQuery<Memory> query = manager.createQuery("SELECT n FROM Memory n", Memory.class);
            return query.getResultList();
        }else if(hardware instanceof Screen){
            TypedQuery<Screen> query = manager.createQuery("SELECT n FROM Screen n", Screen.class);
            return query.getResultList();
        }else if(hardware instanceof VideoCard){
            TypedQuery<VideoCard> query = manager.createQuery("SELECT n FROM VideoCard n", VideoCard.class);
            return query.getResultList();
        }
        return null;
    }

    public NoteBook setNewNotebook(){
        System.out.println("Chose notebook's model:");
        Model model = (Model) showInfo(new Model());
        System.out.println("Chose notebook's processor:");
        Proc processor = (Proc) showInfo(new Proc());
        System.out.println("Chose notebook's memory:");
        Memory memory = (Memory) showInfo(new Memory());
        System.out.println("Chose notebook's hdd:");
        Hdd hdd = (Hdd) showInfo(new Hdd());
        System.out.println("Chose notebook's videocard:");
        VideoCard videocard = (VideoCard) showInfo(new VideoCard());
        System.out.println("Chose notebook's screen:");
        Screen screen = (Screen) showInfo(new Screen());
        return new NoteBook(model, processor, hdd, memory, videocard, screen);
    }

    private IHardware showInfo(IHardware hardware){
        List<IHardware> list = getAllHardware(hardware);
        int i = 1;
        for (IHardware iHardware : list) {
            System.out.println(i + ". " + iHardware);
            i++;
        }
        return list.get(scanner.nextInt() - 1);
    }
}

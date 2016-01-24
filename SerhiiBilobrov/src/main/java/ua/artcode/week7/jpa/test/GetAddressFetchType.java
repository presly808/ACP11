package ua.artcode.week7.jpa.test;

import ua.artcode.week7.jpa.model.Address;
import ua.artcode.week7.jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by serhii on 24.01.16.
 */
public class GetAddressFetchType {


    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hibernate-unit");

        EntityManager manager = factory.createEntityManager();

        Address address = manager.find(Address.class, 5);
        List authors = address.getAuthorList();
        System.out.println(address);


    }
}

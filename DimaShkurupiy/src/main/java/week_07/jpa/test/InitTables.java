package week_07.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 23.01.16.
 */
public class InitTables {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
    }

}

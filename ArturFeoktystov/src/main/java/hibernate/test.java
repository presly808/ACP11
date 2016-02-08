package hibernate;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {


    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");


    }

}

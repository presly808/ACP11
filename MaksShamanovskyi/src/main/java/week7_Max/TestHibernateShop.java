package week7_Max;

import week6_Max.model.NoteBook;

import java.util.List;

public class TestHibernateShop {
    public static void main(String[] args) {

        ShopDao shopDao = new ShopDao();
        List<NoteBook> list = shopDao.getAllNotebooks();

    }
}

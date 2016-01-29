package week7_Max;

import week6_Max.model.*;


import java.util.List;

public class TestHibernateShop {
    public static void main(String[] args) {

        ShopDao shop = new ShopDao();
        NoteBook nb = shop.setNewNotebook();
        shop.create(nb);
        List<NoteBook> list = shop.getAllNotebooks();
    }
}

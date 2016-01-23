package nbstock.model;

import java.util.Date;

/**
 * Created by Dima on 18.01.2016.
 */
public class StockOperation {
    private int id;
    private Product product;
    private int operation; // +1|-1
    private int quantity;
    private int partNumber; // номер партии ? а нафига. что бы первый пришел - первый ушел? вдруг не ноутбуки а молоко 3 дня срок годности
    private float price;
    private Date date;
}

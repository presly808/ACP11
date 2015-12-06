package tourniquet.controller;

import tourniquet.model.Card;

/**
 * Created by 1 on 05.12.2015.
 */
public interface iTourniquetController {

    boolean registerNew(Integer cardNumber, String ownerName);
    boolean scanIn(Card card);
    boolean scanOut(Card card);
    void showAllCards();
    void showCurrentIns();
    void showAllIns(String date);




}

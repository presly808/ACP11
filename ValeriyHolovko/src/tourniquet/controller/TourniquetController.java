package tourniquet.controller;

import tourniquet.model.Card;
import tourniquet.model.TourniquetDB;

/**
 * Created by 1 on 05.12.2015.
 */
public class TourniquetController implements iTourniquetController {

    private TourniquetDB db;


    @Override
    public boolean registerNew(Integer cardNumber, String ownerName) {

        Card newCard = new Card(cardNumber,ownerName);

        if (db.getCards().get(newCard) == null) {
            return db.getCards().put(newCard,true);
        }
        return false;
    }

    @Override
    public boolean scanIn(Card card) {

        if (db.getCards().get(card) != null){

            //db.getCards().get(card) = false;   set false for ability to in

            return true;
        }

        return false;

    }

    @Override
    public boolean scanOut(Card card) {
        return false;
    }

    @Override
    public void showAllCards() {

    }

    @Override
    public void showCurrentIns() {

    }

    @Override
    public void showAllIns(String date) {

        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //dateFormat.format(new Date());

    }
}

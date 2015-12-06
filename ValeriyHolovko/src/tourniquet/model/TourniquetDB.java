package tourniquet.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 05.12.2015.
 */
public class TourniquetDB {

    CardsTreeMap<Card,Boolean> cards = new CardsTreeMap<>(new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getNumber() < o2.getNumber()){
                return -1;
            } else if (o1.getNumber() > o2.getNumber()){
                return 1;
            }
            return 0;

        }
    });  // Key - Card; if present ->  check if its already in(false) or out(true)
    //Map<String,ArrayList<>> cardPassRecord = new HashMap<>();  // Key - date;  Value -> List of Ins and Outs


    public CardsTreeMap<Card, Boolean> getCards() {
        return cards;
    }

    public void setCards(CardsTreeMap<Card, Boolean> cards) {
        this.cards = cards;
    }
}

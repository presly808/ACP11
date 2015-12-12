package tourniquet.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by 1 on 05.12.2015.
 */
public class TourniquetDB {

    CardsTreeMap<Card,Boolean> cardsAbilityToEnter = new CardsTreeMap<>(new Comparator<Card>() {
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

    CardsTreeMap<Card,ArrayList<CardPassRecord>> cardsPass = new CardsTreeMap<>(new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getNumber() < o2.getNumber()){
                return -1;
            } else if (o1.getNumber() > o2.getNumber()){
                return 1;
            }
            return 0;

        }
    });

    public CardsTreeMap<Card, Boolean> getCardsAbilityToEnter() {
        return cardsAbilityToEnter;
    }

    public void setCardsAbilityToEnter(CardsTreeMap<Card, Boolean> cardsAbilityToEnter) {
        this.cardsAbilityToEnter = cardsAbilityToEnter;
    }

    public CardsTreeMap<Card, ArrayList<CardPassRecord>> getCardsPass() {
        return cardsPass;
    }

    public void setCardsPass(CardsTreeMap<Card, ArrayList<CardPassRecord>> cardsPass) {
        this.cardsPass = cardsPass;
    }
}

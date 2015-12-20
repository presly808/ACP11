package tourniquet;

import java.util.ArrayList;

public class CardDB {

    private List<Card> cards;
    private List<ArrayList<Time>> time;

    public CardDB() {
        this.cards = new ArrayList<Card>();
        this.time = new ArrayList<ArrayList<Time>>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


    public ArrayList<ArrayList<Time>> getTime() {
        return time;
    }
}

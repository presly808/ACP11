package tourniquet;


import java.util.ArrayList;

public class Database {

    private ArrayList<Card> cards;
    private ArrayList<ArrayList<TimeTracking>> timeTracking;

    public Database() {
        this.cards = new ArrayList<Card>();
        this.timeTracking = new ArrayList<ArrayList<TimeTracking>>();
    }

    public ArrayList<ArrayList<TimeTracking>> getTimeTracking() {
        return timeTracking;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

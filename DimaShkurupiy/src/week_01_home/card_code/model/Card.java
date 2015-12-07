package week_01_home.card_code.model;

/**
 * Created by Dima on 07.12.2015.
 */
public class Card {
    private static int currentId; //default 0

    private Transaction session;

    private int id;
    private String name;
    private int accessLevel; // there is only one card sence

    public Card(String name) {
        this.id = ++currentId;
        this.name = name;
        this.session = null;
    }

    public Transaction getSession() {
        return session;
    }

    public void setSession(Transaction session) {
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Card #" + this.id + " [ " + this.name + " ] is " + ( this.session != null ? "IN" : "OUT" );
    }
}

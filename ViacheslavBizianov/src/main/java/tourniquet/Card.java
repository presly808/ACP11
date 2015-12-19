package tourniquet;


import java.util.ArrayList;

public class Card {
    private String name;
    private int id;

    public Card(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

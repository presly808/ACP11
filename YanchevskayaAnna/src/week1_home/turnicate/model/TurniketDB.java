package week1_home.turnicate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 06.12.2015.
 */
public class TurniketDB {

    private Map<Integer,String> cards = new HashMap<>();
    private Map<Integer, Map <Date, List<Operation>>> operations = new HashMap<>();
    private Time amountTime;

    public Map<Integer, Map<Date, List<Operation>>> getOperations() {
        return operations;
    }

    public void setOperations(Map<Integer, Map<Date, List<Operation>>> operations) {
        this.operations = operations;
    }

    public void setAmountTime(Time amountTime) {
        this.amountTime = amountTime;
    }

    public Map<Integer, String> getCards() {
        return cards;
    }

    public void setCards(Map<Integer, String> cards) {
        this.cards = cards;
    }

    public Time getAmountTime() {
        return amountTime;
    }
}

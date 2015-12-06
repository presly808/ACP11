package tourniquet;


public class Card {


    private int cardID;
    private String cardHolder;


    public Card(int cardID, String cardHolder) {
        this.cardID = cardID;
        this.cardHolder = cardHolder;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}

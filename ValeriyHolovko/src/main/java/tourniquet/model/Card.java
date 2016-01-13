package tourniquet.model;

/**
 * Created by 1 on 05.12.2015.
 */
public class Card implements Comparable {

    private Integer number;
    private String owner;


    public Card(Integer number, String owner) {
        this.number = number;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Card)){
            return false;
        } else if (!(this.number.equals(((Card) obj).number))){
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Card)){
            throw new ClassCastException();
        }

        if (number < ((Card) o).number){
            return -1;
        } else if (number > ((Card) o).number){
            return 1;
        }

        return 0;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

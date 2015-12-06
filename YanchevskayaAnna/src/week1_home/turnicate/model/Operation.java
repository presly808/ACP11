package week1_home.turnicate.model;

/**
 * Created by Anna on 05.12.2015.
 */
public class Operation {
    private Integer cardId;
    private Time time;
    private TypeOfOperation type;

    public Operation(Integer cardId, Time time, TypeOfOperation type) {
        this.cardId = cardId;
        this.time = time;
        this.type = type;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TypeOfOperation getType() {
        return type;
    }

    public void setType(TypeOfOperation type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "cardId=" + cardId +
                ", time=" + time +
                ", type=" + type +
                '}';
    }
}

package week_01_home.card_code.model;

/**
 * Created by Dima on 07.12.2015.
 */
public class CardReader {
    private static int currentId;

    private boolean openToPass;

    private int id;
    private String note;

    // constructor for search
    public CardReader(int id) {
        this.id = id;
    }

    public CardReader(String note) {
        this.id = ++currentId;
        this.note = note;
        this.openToPass = true;
    }

    public boolean isOpenToPass() {
        return openToPass;
    }

    private void setOpenToPass(boolean openToPass) {
        this.openToPass = openToPass;
    }

    public void close(){
        this.setOpenToPass(false);
    }

    public void open(){
        this.setOpenToPass(true);
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "CardReader #" + this.id + " [ " + this.note + " ] is " + ( this.openToPass ? "OPEN" : "CLOSE" );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardReader that = (CardReader) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

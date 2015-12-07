package week_01_home.card_code.model;

/**
 * Created by Dima on 07.12.2015.
 */
public class CardReader {
    private static int currentId;

    private boolean openToPass;

    private int id;
    private String note;

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
}

package nbstock.model.product;

/**
 * Created by Dima on 18.01.2016.
 */
public class Display {
    private int id;
    private String manufacturer;
    private int displaySize;

    public Display(String manufacturer, int displaySize) {
        this.manufacturer = manufacturer;
        this.displaySize = displaySize;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

/*    public boolean equals(Display otherDisplay) {
        return ( otherDisplay.getDisplaySize() == this.displaySize && otherDisplay.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Display)) return false;

        Display display = (Display) o;

        //if (getId() != display.getId()) return false;
        if (getDisplaySize() != display.getDisplaySize()) return false;
        return getManufacturer() != null ? getManufacturer().equals(display.getManufacturer()) : display.getManufacturer() == null;

    }

    @Override
    public int hashCode() {
        return getId();
    }
}

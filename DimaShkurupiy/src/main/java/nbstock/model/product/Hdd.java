package nbstock.model.product;

/**
 * Created by Dima on 18.01.2016.
 */
public class Hdd {
    private int id;
    private String manufacturer;
    private int capacity;

    public Hdd(String manufacturer, int capacity) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

/*    public boolean equals(Hdd otherHdd) {
        return ( otherHdd.getCapacity() == this.capacity && otherHdd.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hdd)) return false;

        Hdd hdd = (Hdd) o;

        //if (getId() != hdd.getId()) return false;
        if (getCapacity() != hdd.getCapacity()) return false;
        return getManufacturer() != null ? getManufacturer().equals(hdd.getManufacturer()) : hdd.getManufacturer() == null;

    }

    @Override
    public int hashCode() {
        return getId();
    }
}

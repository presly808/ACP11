package nbstock.model.product;

/**
 * Created by Dima on 18.01.2016.
 */
public class Memory {
    private int id;
    private String manufacturer;
    private int memSize;

    public Memory(String manufacturer, int memSize) {
        this.manufacturer = manufacturer;
        this.memSize = memSize;
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

    public int getMemSize() {
        return memSize;
    }

    public void setMemSize(int memSize) {
        this.memSize = memSize;
    }

/*    public boolean equals(Memory otherMemory) {
        return ( otherMemory.getMemSize() == this.memSize && otherMemory.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;

        Memory memory = (Memory) o;

        //if (getId() != memory.getId()) return false;
        if (getMemSize() != memory.getMemSize()) return false;
        return getManufacturer() != null ? getManufacturer().equals(memory.getManufacturer()) : memory.getManufacturer() == null;

    }

    @Override
    public int hashCode() {
        return getId();
    }
}

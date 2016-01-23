package nbstock.model.product;

/**
 * Created by Dima on 18.01.2016.
 */
public class Video {
    private int id;
    private String manufacturer;
    private int memSize;

    public Video(String manufacturer, int memSize) {
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

/*    public boolean equals(Video otherVideo) {
        return ( otherVideo.getMemSize() == this.memSize && otherVideo.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;

        Video video = (Video) o;

        //if (getId() != video.getId()) return false;
        if (getMemSize() != video.getMemSize()) return false;
        return getManufacturer() != null ? getManufacturer().equals(video.getManufacturer()) : video.getManufacturer() == null;

    }

    @Override
    public int hashCode() {
        return getId();
    }
}

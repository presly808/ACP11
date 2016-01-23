package week6_Max;

public class VideoCard {
    private String company;
    private int size;

    public VideoCard(String company, int size) {
        this.company = company;
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VideoCard{" +
                "company='" + company + '\'' +
                ", size=" + size +
                "MB}";
    }
}

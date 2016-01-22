package week6_Max;

public class Hdd {
    private String company;
    private int size;

    public Hdd(String company, int size) {
        this.company = company;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Hdd{" +
                "company='" + company + '\'' +
                ", size=" + size +
                "GB}";
    }
}

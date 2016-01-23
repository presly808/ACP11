package week6_Max;

public class Memory {
    private String company;
    private int size;

    public Memory(String company, int size) {
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
        return "Memory{" +
                "company='" + company + '\'' +
                ", size=" + size +
                "GB}";
    }
}

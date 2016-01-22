package week6_Max;

public class Proc {
    private String company;
    private int frequency;

    public Proc(String company, int frequency) {
        this.company = company;
        this.frequency = frequency;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Proc{" +
                "company='" + company + '\'' +
                ", frequency=" + frequency +
                "GHz}";
    }
}

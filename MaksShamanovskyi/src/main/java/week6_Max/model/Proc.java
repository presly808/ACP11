package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "proces")
public class Proc implements IHardware{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int frequency;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "proc_id",
            referencedColumnName = "id")
    private NoteBook noteBook;

    public Proc() {
    }

    public Proc(String company, int frequency) {
        this.company = company;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

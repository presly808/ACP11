package week6_Max.model;

import javax.persistence.*;


@Entity
@Table(name = "hdd")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int size;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hdd_id",
            referencedColumnName = "id")
    private NoteBook noteBook;

    public Hdd(String company, int size) {
        this.company = company;
        this.size = size;
    }

    public Hdd() {
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

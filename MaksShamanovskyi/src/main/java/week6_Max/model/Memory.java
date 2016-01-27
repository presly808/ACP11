package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "memory")
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int size;

    @OneToMany(mappedBy = "memory", fetch = FetchType.EAGER)
    private NoteBook noteBook;

    public Memory() {
    }

    public Memory(String company, int size) {
        this.company = company;
        this.size = size;
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

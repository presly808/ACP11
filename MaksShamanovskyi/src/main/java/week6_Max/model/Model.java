package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String model;

    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
    private NoteBook noteBook;

    public Model() {
    }

    public Model(String company, String model) {
        this.company = company;
        this.model = model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Model{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

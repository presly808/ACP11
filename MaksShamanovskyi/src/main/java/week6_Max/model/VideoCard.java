package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "vcards")
public class VideoCard {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int size;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vcard_id",
            referencedColumnName = "id")
    private NoteBook noteBook;

    public VideoCard() {
    }

    public VideoCard(String company, int size) {
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
        return "VideoCard{" +
                "company='" + company + '\'' +
                ", size=" + size +
                "MB}";
    }
}

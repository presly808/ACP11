package week_07.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by serhii on 23.01.16.
 */

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private String autor;

    @Column
    private String city;

    @Column
    private int pages;

    @Column(nullable = false)
    private float price;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Enumerated(EnumType.STRING)
    private EType eType;

    public Book() {
    }

    public Book(String name, String autor, String city, int pages, float price, Date publicationDate, EType type) {
        this.name = name;
        this.autor = autor;
        this.city = city;
        this.pages = pages;
        this.price = price;
        this.publicationDate = publicationDate;
        this.eType = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public EType getType() {
        return eType;
    }

    public void setType(EType type) {
        this.eType = type;
    }

    public enum EType {
        IT,
        DRAMA,
        COMEDY,
        FANTASTICS,
        SHIT;
    }
}




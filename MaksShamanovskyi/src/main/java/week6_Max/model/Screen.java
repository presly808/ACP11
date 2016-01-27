package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "screens")
public class Screen {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private float size;

    @OneToMany(mappedBy = "screen", fetch = FetchType.EAGER)
    private NoteBook noteBook;

    public Screen() {
    }

    public Screen(float size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "size=" + size +
                '}';
    }
}

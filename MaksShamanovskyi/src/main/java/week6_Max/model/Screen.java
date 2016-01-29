package week6_Max.model;

import javax.persistence.*;

@Entity
@Table(name = "screens")
public class Screen implements IHardware{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private float size;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "screen_id",
            referencedColumnName = "id")
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

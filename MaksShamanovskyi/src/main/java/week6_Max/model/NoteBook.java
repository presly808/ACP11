package week6_Max.model;


import javax.persistence.*;

@Entity
@Table(name = "notebooks")
public class NoteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_id",
            referencedColumnName = "id")
    private Model model;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "proc_id",
            referencedColumnName = "id")
    private Proc processor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hdd_id",
            referencedColumnName = "id")
    private Hdd hdd;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "memory_id",
            referencedColumnName = "id")
    private Memory memory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vcard_id",
            referencedColumnName = "id")
    private VideoCard videoCard;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "screen_id",
            referencedColumnName = "id")
    private Screen screen;

    public NoteBook() {
    }

    public NoteBook(Model model, Proc processor, Hdd hdd, Memory memory, VideoCard videoCard, Screen screen) {
        this.model = model;
        this.processor = processor;
        this.hdd = hdd;
        this.memory = memory;
        this.videoCard = videoCard;
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Proc getProcessor() {
        return processor;
    }

    public void setProcessor(Proc processor) {
        this.processor = processor;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "model=" + model +
                ", processor=" + processor +
                ", hdd=" + hdd +
                ", memory=" + memory +
                ", videoCard=" + videoCard +
                ", screen=" + screen +
                '}';
    }
}

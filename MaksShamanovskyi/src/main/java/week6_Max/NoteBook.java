package week6_Max;

public class NoteBook {
    private Model model;
    private Proc processor;
    private Hdd hdd;
    private Memory memory;
    private VideoCard videoCard;
    private Screen screen;

    public NoteBook(Model model, Proc processor, Hdd hdd, Memory memory, VideoCard videoCard, Screen screen) {
        this.model = model;
        this.processor = processor;
        this.hdd = hdd;
        this.memory = memory;
        this.videoCard = videoCard;
        this.screen = screen;
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

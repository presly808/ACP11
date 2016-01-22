package week6_Max;

public class Screen {
    private float size;

    public Screen(float size) {
        this.size = size;
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

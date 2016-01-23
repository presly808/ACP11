package nbstock.model;

import nbstock.model.product.*;

/**
 * Created by Dima on 18.01.2016.
 */
public class Product {
    private int id;
    private Model model;
    private Cpu cpu;
    private Hdd hdd;
    private Memory memory;
    private Video video;
    private Display display;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        //if (id != product.id) return false;
        if (!model.equals(product.model)) return false;
        if (!cpu.equals(product.cpu)) return false;
        if (!hdd.equals(product.hdd)) return false;
        if (!memory.equals(product.memory)) return false;
        return video.equals(product.video);

    }

    @Override
    public int hashCode() {
        return id;
    }
}

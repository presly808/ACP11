package ua.artcode.home.week4;

/**
 * Created by serhii on 26.12.15.
 */
public class Car {

    private final String num;
    private final String model;
    private final int speed;

    public Car(String num, String model, int speed) {
        this.num = num;
        this.model = model;
        this.speed = speed;
    }


    public String getNum() {
        return num;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }
}

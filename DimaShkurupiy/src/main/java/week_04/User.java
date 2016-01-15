package week_04;

/**
 * Created by Dima on 26.12.2015.
 */
public class User {
    private static int id;

    public String name;
    public String phone;

    @NonTrivialField
    public Car car;

    public User() {
    }

    public User(String name, String phone, Car car) {
        this.id++;
        this.name = name;
        this.phone = phone;
        this.car = car;
    }
}

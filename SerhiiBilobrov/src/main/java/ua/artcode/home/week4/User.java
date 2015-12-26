package ua.artcode.home.week4;

import java.util.List;

/**
 * Created by serhii on 26.12.15.
 */
public class User {

    protected static int count;

    public int id;
    int age;
    String name;
    String phone;
    private List<String> addresses;

    private Car car;

    public User() {
    }

    public User(String phone, String name, int age, int id, Car car) {
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.id = id;
        this.car = car;
    }

    public User(int id, int age, String name, String phone) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", addresses=" + addresses +
                ", car=" + car +
                '}';
    }
}

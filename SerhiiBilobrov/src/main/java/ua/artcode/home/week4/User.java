package ua.artcode.home.week4;

import java.util.List;

public class User {

    protected static int count;

    @ForSave
    public int id;
    @ForSave
    public int age;
    @ForSave
    public String name;
    @ForSave
    public String phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return !(phone != null ? !phone.equals(user.phone) : user.phone != null);

    }


}

package xml;

/**
 * Created by slava23 on 12/22/2015.
 */
public class Person {

    private String name;
    private int age;
    public Book[] books;

    public Person(String name, int age, Book[] books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Book[] getBooks() {
        return books;
    }
}

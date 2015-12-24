package xml;

import org.w3c.dom.Document;

/**
 * Created by slava23 on 12/22/2015.
 */
public class Person /*implements XMLBinded*/ {

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

    public Document structure(){
        return null;
    }
}

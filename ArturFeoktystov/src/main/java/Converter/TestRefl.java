package Converter;


public class TestRefl {

    public static void main(String[] args) throws IllegalAccessException {

        User user = new User(1, "Andrew", 30, "Kiev");

        System.out.println(Reflection.convertObjToString(user));


    }

}

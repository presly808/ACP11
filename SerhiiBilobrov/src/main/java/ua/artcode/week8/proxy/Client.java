package ua.artcode.week8.proxy;

/**
 * Created by serhii on 31.01.16.
 */
public class Client {


    public static void main(String[] args) {
        MathService mathService = MathServiceFactory.create();
        mathService.add(23,45);
    }

}

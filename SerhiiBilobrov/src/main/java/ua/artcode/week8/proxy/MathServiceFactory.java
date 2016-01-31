package ua.artcode.week8.proxy;

/**
 * Created by serhii on 31.01.16.
 */
public class MathServiceFactory {
    public static MathService create() {
        return new MathServiceProxy(new MathServiceImpl());
    }
}

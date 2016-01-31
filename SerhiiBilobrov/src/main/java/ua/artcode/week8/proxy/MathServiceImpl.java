package ua.artcode.week8.proxy;

/**
 * Created by serhii on 31.01.16.
 */
public class MathServiceImpl implements MathService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

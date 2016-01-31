package ua.artcode.library.validator;

/**
 * Created by serhii on 30.01.16.
 */
public interface Validator<T> {


    boolean isValid(T in);

}

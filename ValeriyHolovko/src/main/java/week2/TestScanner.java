package week2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.*;

/**
 * Created by 1 on 18.12.2015.
 */
public class TestScanner {

    public static void main(String[] args) {

        char[] array = new char[10];
        Reader reader = new StringReader("Some text");

        int result = 0;

        try {
            result = reader.read(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}

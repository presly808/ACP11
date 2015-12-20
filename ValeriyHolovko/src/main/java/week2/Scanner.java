package week2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 18.12.2015.
 */
public class Scanner implements IScanner{

    private Reader reader;

    private int DEFAULT_BUFFER_SIZE = 128;
    private char[] buffer = new char[DEFAULT_BUFFER_SIZE];

    private char DEFAULT_DELIMITER = ' ';

    int start = 0;
    int end = 0;






    public Scanner(String inputText) {

        reader = new StringReader(inputText);
        writeToBuffer();

    }


    private void writeToBuffer() {
        try {
            reader.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String next() {

        if (!hasNext()){
            throw new NoSuchElementException();
        }


        String result = "";

        for (int i = 0; i < end || buffer[i] != DEFAULT_DELIMITER; i++) {
            result += buffer[i];
        }


        return result;
    }

    @Override
    public String nextLine() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < end; i++) {
            result.append(buffer[i]);
        }

        return null;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public double nextDouble() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public boolean hasNextDouble() {
        return false;
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    private class NoNextElementInBufferException extends Throwable {
    }
}

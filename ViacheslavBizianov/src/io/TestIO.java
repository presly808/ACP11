package io;

import java.io.FileNotFoundException;

/**
 * Created by slava23 on 12/12/2015.
 */
public class TestIO {
    public static void main(String[] args) throws FileNotFoundException {
        IOmethods iOmethods = new IOmethods();
        String path = "C:\\Users\\slava23\\ACP11\\home\\week1.txt";
        iOmethods.readFromFile(path);
    }
}

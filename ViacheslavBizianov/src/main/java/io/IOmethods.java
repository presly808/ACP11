package io;


import java.io.*;

public class IOmethods {

    public void readFromFile(String path) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(path));
        int count = 0;
        int symbol = 0;
        while (count < 10){
            try {
                symbol = is.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(symbol + " ");
            count++;
        }
    }

}

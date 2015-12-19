package io_1;


import java.io.*;
import java.util.zip.GZIPInputStream;

public class DataOutputClass {
    public static void main(String[] args) throws IOException {

        byte age = 27;
        String name = "Viacheslav";
        int[] array = new int[]{4,5,8,12,11};

        String filePath = "C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\info.txt";

        InputStream inputStream = new GZIPInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                new File(filePath)
                        )
                )
        );

    DataInput dataInput = new DataInputStream(inputStream);


    }


}

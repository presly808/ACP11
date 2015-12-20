package ua.artcode.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by serhii on 12.12.15.
 */
public class IOMethodContainer {

    // img, mp3, exe
    public static int[] readFileContent(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        int[] res = new int[1024];
        int coun = 0;
        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                if (coun >= res.length) {
                    res = Arrays.copyOf(res, res.length * 2);
                }
                res[coun++] = temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static String readFileCodeContentAsString(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        String res = "";
        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                res += temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }


    // txt,
    public static String readFileContentAsString(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        String res = "";
        try {
            int temp = 0;
            while ((temp = is.read()) != -1) {
                res += (char) temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static String readFileContentBuff(String path) throws FileNotFoundException {

        InputStream is = new FileInputStream(path);
        byte[] buff = new byte[1024];
        String res = "";

        try {
            int length = 0;
            while ((length = is.read(buff)) != -1){
                res += new String(buff,0,length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }




}

package url;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class DownloadFile {
    public static void main(String[] args) {
      String PATH = "https://github.com/presly808/ACP11/blob/master/home/week3.txt";

        URL url = null;
        try {
            url = new URL(PATH);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            InputStream is = new BufferedInputStream(url.openStream());
            char[] buffer = new char[100];
            int index;
            int count = 0;
            while ((index = is.read()) != -1){
                if (count >= buffer.length){
                    buffer = Arrays.copyOf(buffer,buffer.length * 2);
                }
                buffer[count++] = (char) index;
            }
            System.out.println(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

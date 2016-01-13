package week_03_home.exdl;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Dima on 27.12.2015.
 */
public class UseExDownLoader {
    public static void main(String[] args) throws IOException {
        ExDownLoader page = new ExDownLoader("http://www.ex.ua/playlist/81995094.xspf");
        System.out.println(page.openPage());
        String fileListXML = page.openPage();


    }
}

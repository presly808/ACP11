package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupUtils {


    public static void getLinks(String url){
        try {
            Document doc = Jsoup.connect(url).get();

            String title = doc.title();
            System.out.println("title: " + title);

            //Elements links = doc.select("a[href*=/load/]");
            Elements links1 = doc.select("a[href*=/get/]");
            for (Element link : links1){
                System.out.println(link.attr("title"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getImages(String url){
        try {
            Document doc = Jsoup.connect(url).get();

            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images){
                System.out.println("\nsrc : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

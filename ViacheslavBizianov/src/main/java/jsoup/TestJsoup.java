package jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestJsoup {
    public static void main(String[] args) {

        final String PATH1 = "http://tpa.kiev.ua";
        final String PATH2 = "http://www.ex.ua/78657081?r=82416,80928";

        //JsoupUtils.getLinks(PATH1);
        //JsoupUtils.getLinks(PATH2);

        ExDownloader.downloadAllFiles(PATH2);

    }
}

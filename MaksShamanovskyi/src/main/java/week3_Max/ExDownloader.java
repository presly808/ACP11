package week3_Max;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;


public class ExDownloader {
    private Document urlPage;
    private ArrayList<String> uniqueLink = new ArrayList<>();
    private ArrayList<String> uniqueName = new ArrayList<>();
    private ArrayList<URL> urls = new ArrayList<>();
    private String filesURL;
    private  Elements name;
    private  Elements link;


    public ExDownloader(String url) {
        if (!(url.startsWith("http://www.ex.ua/"))) {
            throw new IncorrectURLAdress("Write correct URL");
        }
        filesURL = url;
        parsing();
    }

    private void parsing() {
        try {
            urlPage = Jsoup.connect(filesURL).get();
            name = urlPage.select("[href*=/get/]");
            link = urlPage.select("[href*=/load/]");
            for (Element e : link) {
                if (e.text().equals("загрузить")) {
                    uniqueLink.add(e.attr("href"));
                    urls.add(new URL("http://ex.ua" + e.attr("href")));
                }
            }
            for (Element e : name) {
                if (!e.text().equals("играть")) {
                    uniqueName.add(e.text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadAllFiles(String FilePath) {
        try {
            for (int i = 0; i < uniqueLink.size(); i++) {
                ReadableByteChannel channel = Channels.newChannel(urls.get(i).openStream());
                FileOutputStream fileStream = new FileOutputStream(new File(FilePath + "\\" + uniqueName.get(i)));
                fileStream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class IncorrectURLAdress extends RuntimeException {
    public IncorrectURLAdress() {
        super();
    }

    public IncorrectURLAdress(String s) {
        super(s);
    }
}

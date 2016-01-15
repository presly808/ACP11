package week5_Max.ex_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class MultyDownloader {
    private Document document;
    private String startPage;
    private String path;
    private Set<String> linkSet = new HashSet<>();
    private List<String> linkList = new ArrayList<>();
    private String text;

    public MultyDownloader(String text, String startPage, String path) {
        this.text = text;
        this.path = path;
        this.startPage = startPage;
    }

    public void start(){
        parsing();
        runSearch();

    }

    private void parsing(){
        try {
            document = Jsoup.connect(startPage).get();
            Elements link = document.select("[href*=/]");
            for (Element e : link) {
                if(e.attr("href").matches("^/\\d+")) {
                    linkSet.add(e.attr("href"));
                }
            }
            linkList.addAll(linkSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runSearch(){
        for (int i = 0; i < linkSet.size(); i++) {
            new Thread(new SearcherDownloader("http://www.ex.ua" + linkList.get(i), path)).start();
        }
    }

}


class SearcherDownloader implements Runnable{
    private String url;
    private String path;

    public SearcherDownloader(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {

    }
}

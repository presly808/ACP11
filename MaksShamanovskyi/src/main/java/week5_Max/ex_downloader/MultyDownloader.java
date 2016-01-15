package week5_Max.ex_downloader;

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
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MultyDownloader {
    private Scanner sc;
    private Document document;
    private String startPage;
    private String path;
    private Set<String> linkSet = new HashSet<>();
    private List<String> linkList = new ArrayList<>();
    private String text;
    private ListURL listURL;
    private ListNames listNames;
    private List<Thread> threads;

    public MultyDownloader(String text, String path) {
        this.text = text;
        this.path = path;
        listURL = new ListURL();
        listNames = new ListNames();
        threads = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void start(){
        findPage();
        parsing();
        runSearch();
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tryDownload();
    }

    private void findPage(){
        if(text != null) {
            String[] words = text.split(" ");
            startPage = "http://www.ex.ua/search?s=" + words[0];
            if(words.length > 1) {
                for (int i = 1; i < words.length; i++) {
                    startPage += "+" + words[i];
                }
            }
        }
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
            Thread sd = new Thread(new SearcherDownloader(listURL, listNames, "http://www.ex.ua" + linkList.get(i)));
            threads.add(sd);
            sd.start();
        }
    }

    private void tryDownload(){
        String delimiter = System.getProperties().getProperty("file.separator");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        int i = 0;
        try {
            while(i < listURL.size()) {
                System.out.println("Would u like to download this file?(Y/N)\n" +
                        listNames.getList().get(i));
                String answer = sc.next();
                if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    ReadableByteChannel channel = Channels.newChannel(listURL.getList().get(i).openStream());
                    FileOutputStream fileStream = new FileOutputStream(
                            new File(path + delimiter + listNames.getList().get(i)));
                    fileStream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ListURL{
        private List<URL> list = new ArrayList<>();
        private Lock monitor = new ReentrantLock(true);

        public int size(){
            return list.size();
        }

        public List<URL> getList() {
            return list;
        }

        public void setURL(URL url) {
            monitor.lock();
            list.add(url);
            monitor.unlock();
        }
    }

    private static class ListNames{
        private List<String> list = new ArrayList<>();
        private Lock monitor = new ReentrantLock(true);

        public List<String> getList() {
            return list;
        }

        public void setName(String url) {
            monitor.lock();
            list.add(url);
            monitor.unlock();
        }
    }

    private static class SearcherDownloader implements Runnable{
        private String url;
        private ListURL listURL;
        private ListNames listNames;


        public SearcherDownloader(ListURL listURL,ListNames listNames, String url) {
            this.listURL = listURL;
            this.url = url;
            this.listNames = listNames;
        }

        @Override
        public void run() {
            try {
                Document page = Jsoup.connect(url).get();
                Elements name = page.select("[href*=/get/]");
                Elements link = page.select("[href*=/load/]");

                for (Element e : link) {
                    if (e.text().equals("загрузить")) {
                        listURL.setURL(new URL("http://ex.ua" + e.attr("href")));
                    }
                }
                for (Element e : name) {
                    if (!e.text().equals("играть")) {
                        listNames.setName(e.text());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

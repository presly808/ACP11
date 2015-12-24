package jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import url.DownloadFile;

import java.io.IOException;

public class ExDownloader {

    public void downloadAllFiles(String path){
        try {
            //get the link
            Document doc = Jsoup.connect(path).get();

            //extract only URLs containing /load/{idOfFile}
            Elements links = doc.select("a[href*=/get/]");
            for (Element link : links){

                String fileToDownloadPAth = "http://www.ex.ua" + link.attr("href");
                String fileToDownLoadName = link.attr("title");
                String whereToSaveTheFile = "C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\main\\resources\\";
                DownloadFile.downloadFile(fileToDownloadPAth,whereToSaveTheFile + fileToDownLoadName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

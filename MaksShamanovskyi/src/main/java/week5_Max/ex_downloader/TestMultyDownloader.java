package week5_Max.ex_downloader;

public class TestMultyDownloader {

    public static void main(String[] args) {
        new SearcherDownloader("http://www.ex.ua/search?s=rammstein+mutter", "TEST").run();
    }
}

package week3_Max;

public class TestDownloader {
    public static void main(String[] args) {
        ExDownloader ed = new ExDownloader("http://www.ex.ua/96198355?r=28712,23776");
        ed.downloadAllFiles("C:\\Users\\Макс\\TEST");
    }
}

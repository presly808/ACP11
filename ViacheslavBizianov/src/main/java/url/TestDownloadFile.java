package url;

import java.io.IOException;

/**
 * Created by slava23 on 12/24/2015.
 */
public class TestDownloadFile {
    public static void main(String[] args) throws IOException {
        String sourcePath = "http://www.ex.ua/get/109424065";
        String targetPath = "C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\main\\resources\\1.jpg";

        DownloadFile.downloadFile(sourcePath,targetPath);
    }
}

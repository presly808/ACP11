import org.junit.Assert;
import org.junit.Test;
import jsoup.ExDownloader;

import java.io.File;

/**
 * Created by slava23 on 12/24/2015.
 */
public class TestExDownloader {

    private ExDownloader exDownloader = new ExDownloader();
    private String PATH = "http://www.ex.ua/78657081?r=82416,80928";

    @Test
    public void downLoadAllFiles(){
        exDownloader.downloadAllFiles(PATH);
        Assert.assertTrue(new File("C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\main\\resources\\1.jpg").exists());
    }
}

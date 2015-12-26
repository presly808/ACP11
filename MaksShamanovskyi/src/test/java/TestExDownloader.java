import org.junit.*;
import week3_Max.ExDownloader;
import org.junit.Assert;
import java.io.File;

public class TestExDownloader {
    private static ExDownloader ex;
    private static File file;

    @BeforeClass
    public static void setUpClass(){
        String home = System.getProperties().getProperty("user.home");
        String delimiter = System.getProperties().getProperty("file.separator");
        ex = new ExDownloader("http://www.ex.ua/96198355?r=28712,23776");
        file = new File(home + delimiter + "TEST");
    }

    @AfterClass
    public static void tearDownClass(){
        ex = null;
    }

    @Before
    public void setUp(){
        if(!file.exists()) {
            file.mkdir();
        }
    }

    @After
    public void tearDown(){
        if(file.exists()) {
            file.delete();
        }
    }

    @Test
    public void isFiles(){
        ex.downloadAllFiles(file.getPath());
        Assert.assertTrue(file.list().length > 0);
    }

    @Test
    public void isFilesLength(){
        ex.downloadAllFiles(file.getPath());
        Assert.assertTrue(file.length() > 4000);
    }
}

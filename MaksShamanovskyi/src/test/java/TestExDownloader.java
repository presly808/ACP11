import org.junit.*;
import week3_Max.ExDownloader;
import org.junit.Assert;
import java.io.File;

public class TestExDownloader {
    private static ExDownloader ex;
    private File file = new File("C:\\Users\\Макс\\TEST");

    @BeforeClass
    public static void setUpClass(){
        ex = new ExDownloader("http://www.ex.ua/96198355?r=28712,23776");
    }

    @AfterClass
    public static void tearDownClass(){
        ex = null;
    }

    @Before
    public void setUp(){
        file.mkdir();
    }

    @After
    public void tearDown(){
        file.delete();
    }

    @Test
    public void isFiles(){
        ex.downloadAllFiles("C:\\Users\\Макс\\TEST");
        Assert.assertTrue(file.list().length > 0);
    }

    @Test
    public void isFilesLength(){
        ex.downloadAllFiles("C:\\Users\\Макс\\TEST");
        Assert.assertTrue(file.length() > 4000);
    }
}

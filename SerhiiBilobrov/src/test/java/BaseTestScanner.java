import org.junit.*;

import week2.*;
import week2_Max.IScanner;

import java.util.NoSuchElementException;

@Ignore
public class BaseTestScanner {

    private IScanner scanner;
    private static String testName = "default for all test";

    public BaseTestScanner(IScanner scanner) {
        this.scanner = scanner;
    }

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){
        scanner = null;
    }

    @Test
    public void nextLine(){
        String line = scanner.nextLine();
        String expected = "22 line1";
        Assert.assertEquals(expected, line);
    }

    @Test
    public void hasNextInt(){
        testName = "hasNextLine";
        Assert.assertTrue(scanner.hasNextInt());
    }

    @Test
    public void hasNextLine(){
        Assert.assertTrue(scanner.hasNext());
    }

    @Test
    public void nextInt(){
        Assert.assertEquals(22, scanner.nextInt());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextClose(){
        scanner.close();
        scanner.next();
    }



}

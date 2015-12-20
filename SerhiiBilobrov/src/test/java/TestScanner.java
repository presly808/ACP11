import org.junit.*;
import ua.artcode.week2.IScanner;
import ua.artcode.week2.Scanner;

import java.util.NoSuchElementException;

public class TestScanner {

    private IScanner scanner;
    private static String testName = "default for all test";

    @Before
    public void setUp(){
        scanner = new Scanner("22 line1\nline2");
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
    @Ignore
    public void nextInt(){
        Assert.assertEquals(22, scanner.nextInt());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextClose(){
        scanner.close();
        scanner.next();
    }



}

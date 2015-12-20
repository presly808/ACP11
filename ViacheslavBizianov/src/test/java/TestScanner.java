import org.junit.*;
import scanner.Scanner;

/**
 * Created by slava23 on 12/19/2015.
 */
public class TestScanner {
    private Scanner scanner;

    @Before
    public void setUp() {
        scanner = new Scanner("212 line1\nline2");
    }

    @Test
    public void hasNext(){
        Assert.assertTrue(true);
    }

    @Test
    public void next(){
        Assert.assertEquals(scanner.next(),"212");
    }

    @Test
    public void nextLine(){
        Assert.assertEquals(scanner.nextLine(),"212 line1");
    }
}

import org.junit.Test;
import week2_Max.IScanner;
import week2_Max.MyScanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestScanner {
    IScanner sc1 = new MyScanner("some text for test");
    IScanner sc2 = new MyScanner("11111 222a2");

    @Test
    public void testHasNext(){
        assertTrue(sc1.hasNext());
    }

    @Test
    public void testNext(){
        assertTrue(sc1.next().equals("some"));
    }

    @Test
    public void testNextLine(){
        sc1.next();
        assertTrue(sc1.nextLine().equals("text for test"));
    }

    @Test
    public void testHasNextInt(){
        assertTrue(sc2.hasNextInt());
    }

    @Test
    public void testNextInt(){
        assertTrue(sc2.nextInt() == 11111);
    }

    @Test
    public void testFalseNextInt(){
        sc2.nextInt();
        assertFalse(sc2.hasNextInt());
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week4_Max.day1.ObjStringConverter;
import week4_Max.day1.User;

public class TestObjStringConverter {
    private String string;
    private Object obj;

    @Before
    public void setUp(){
        string = "type=week4_Max.day1.User\nid=57\nage=25\nname=Ivan\n";
        obj = new User(57, 25, "Ivan");
    }

    @Test
    public void ObjToString(){
        String str = ObjStringConverter.toString(obj);
        boolean res = str.equals(string);
        Assert.assertTrue(res);
    }

    @Test
    public void StringToObj(){
        Object user = ObjStringConverter.toObject(string);
        Assert.assertEquals(obj, user);
    }

}

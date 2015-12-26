package week4.reflect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.home.week4.User;
import ua.artcode.week4.reflection.ObjectSrtConverterImpl;
import ua.artcode.week4.reflection.ObjectStrConverter;

/**
 * Created by serhii on 26.12.15.
 */
public class TestObjConverter {

    private ObjectStrConverter objectStrConverter;

    private User user;
    private String strUser =
            "type=ua.artcode.home.week4.User\n" +
                    "id=1\n" +
                    "age=23\n" +
                    "name=Kolia\n" +
                    "phone=+324343\n";

    @Before
    public void setUp() throws Exception {
        objectStrConverter = new ObjectSrtConverterImpl();
        user = new User(1,23,"Kolia","+324343");
    }

    @Test
    public void testObjToStr(){
        String res = objectStrConverter.toString(user);
        Assert.assertTrue(res.equals(strUser));
    }

    @Test
    public void testStrToObj(){
        Object convertedUser = objectStrConverter.toObject(strUser);
        Assert.assertEquals(user, convertedUser);
    }

}

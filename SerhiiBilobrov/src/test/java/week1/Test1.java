package week1;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test1 {


    @Test
    public void testHamcrest(){
       assertThat(4*2,allOf(is(2*8),not(12),any(int.class)));
    }

}

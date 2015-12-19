package ua.artcode.test.week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class MapTest extends AbstractTest {

    private Map map;

    public MapTest(Map map) {
        this.map = map;
        testResultList = new ArrayList<>();
    }

    private void tearDown(){
        map.clear();
    }

    public void testPut(){
        map.put(1, 2);
        if(!map.isEmpty()){
            System.out.println("Ok");
        } else {
            System.out.println("Fail");
        }

        map.clear();
    }

    public void testContainsKey(){
        map.put(1, 2);

        testResultList.add(new TestResult(
                "containsKey", "1", "true",
                String.valueOf(map.containsKey(1))));

        map.clear();
    }

    public void testGetValues(){


        int count = 10;

        for (int i = 0; i < count; i++) {
            map.put(i,"test");
        }

        Collection values = map.values();
        if(values.size() == count){
            System.out.println("Ok");
        } else {
            System.out.println("Fail");
        }

        map.clear();
    }

    public void startAllTests(){
        testPut();
        testContainsKey();
        testGetValues();
    }

}

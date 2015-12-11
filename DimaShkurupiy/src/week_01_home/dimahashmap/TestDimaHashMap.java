package week_01_home.dimahashmap;

/**
 * Created by dima on 08.12.2015.
 */
public class TestDimaHashMap {
    public static void main(String[] args) {
        //DimaHashMap<Integer,String> dhm = new DimaHashMap<>();
        DimaHashMap<String,String> dhm = new DimaHashMap<>();

        /* pass ok
        System.out.println("isEmpty " + dhm.isEmpty());
        System.out.println("size " + dhm.size());
        */

        /* pass ok
        // test key == null
        try{
            dhm.put(null,"test_value_1");
            System.out.println("put success");
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
        */

        /* pass ok
        // test hashcode for Integer and String wrappers
        Integer i = new Integer(333);
        System.out.println(i.hashCode());
        String s = new String("abc");
        System.out.println(s.hashCode());
        */

        /*
        //Integer
        dhm.put(0,"test_value_0");
        dhm.put(1 ,"test_value_1");
        dhm.put((Integer) 11 ,"test_value_11");
        */

        //String
        dhm.put("0","test_value_0");
        dhm.put("1" ,"test_value_1");
        dhm.put("abc","test_value_2");
        dhm.put("123abc" ,"test_value_3");
        dhm.put("zxc","test_value_4");
        dhm.put("987" ,"test_value_5");
        dhm.put("iii","test_value_6");
        dhm.put("hgt5" ,"test_value_7");
        dhm.put("hgt51" ,"test_value_8");
        System.out.println("rewrited: " + dhm.put("zxc","test_value_4_XXX") + " by test_value_4_XXX");

        // get
        System.out.println(dhm.get("0"));
        System.out.println(dhm.get("1"));
        System.out.println(dhm.get("abc"));
        System.out.println(dhm.get("123abc"));
        System.out.println(dhm.get("zxc"));
        System.out.println(dhm.get("987"));
        System.out.println(dhm.get("iii"));
        System.out.println(dhm.get("hgt5"));
        System.out.println(dhm.get("hgt51"));


    }
}

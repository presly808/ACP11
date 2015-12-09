package week1_home.hashstructure;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap(100);
        myHashMap.put("мова", "language");
        myHashMap.put("покращити", "improve");
        myHashMap.put("допомога", "help");

        System.out.println(myHashMap.containsKey("покращити"));
        System.out.println(myHashMap.containsKey("не покращити"));

        System.out.println(myHashMap.containsValue("improve"));
        System.out.println(myHashMap.containsValue("don't improve"));
    }

}

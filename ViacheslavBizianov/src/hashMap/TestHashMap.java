package hashMap;


import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer,String> myHashMap = new MyHashMap<>();

        myHashMap.display();
        myHashMap.put(3,"three");
        myHashMap.put(7,"seven");
        myHashMap.put(13,"thirteen");
        myHashMap.put(5,"five");
        myHashMap.put(6,"six");
        myHashMap.put(1,"one");
        myHashMap.put(2,"two");
        myHashMap.display();
        myHashMap.put(10,"ten");
        myHashMap.display();
        myHashMap.put(18,"eighteen");
        myHashMap.display();
    }
}

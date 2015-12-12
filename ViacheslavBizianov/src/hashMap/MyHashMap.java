package hashMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K,V> implements Map<K,V> {

    private Entry<K,V>[] keys;
    private int size = 11;
    private int totalNumberKeys = 0;
    private double loadFactor = 0.75;

    public MyHashMap() {
        this.keys = new Entry[size];
    }

    public Entry[] getKeys() {
        return keys;
    }

    public void display(){
        System.out.println("*** HASH TABLE ***");
        for (int i=0; i<keys.length; i++){
            if (keys[i] != null) {
                System.out.print(keys[i].toString() + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println("");
    }

    public V put(K key, V value){
        int index = key.hashCode() % size;
        while (keys[index] != null){
            index++;
            index %= size; //guarantees returning to the begin of hashtable if last cell is not empty
        }
        keys[index] = new Entry<K,V>(key,value);
        totalNumberKeys++;
        if (totalNumberKeys/(double)size >= loadFactor){
            resize();
        }
        return value;
    }

    private void resize() {
        Entry<K,V>[] tempKeys = keys; //temp array to store the existed entries

        //find the nearest prime number to 2*size
        size = 2*size+1;
        if (!isPrime(size)){
            size = getPrime(size);
        }

        Entry<K,V>[] newKeys = new Entry[size]; //create new array which is 2 times longer

        keys = newKeys;
        totalNumberKeys = 0;
        for (Entry<K,V> entry : tempKeys){
            if (entry != null){
                put(entry.getKey(),entry.getValue());
            }
        }
    }

    private int getPrime(int size) {
        for (int i=size+1; true; i++){
            if (isPrime(i)){
                return i;
            }
        }
    }

    //check whether number is prime
    private boolean isPrime(int number){
        for (int i=2; (i*i)<=number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (totalNumberKeys == 0);
    }

    @Override
    public boolean containsKey(Object key) {
        return (get(key) != null);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() % size;
        while (keys[index] != null){
            if (keys[index].key.equals(key)){
                return keys[index].value;
            } // collision process
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private static class Entry<K,V> {
        private K key;
        private V value;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

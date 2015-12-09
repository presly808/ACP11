package week1_home.hashstructure;

/*Implement Map interface based on hashtable
see example (ua.artcode.ds.hash.MyHashMap)
        Must use: Generics, Exceptions,
        loadFactor(rehashing)
        implement Iterator (for keys and values)

        !Your type that you put in map must override (equals, hashCode)*/


import java.util.*;

public class MyHashMap<K,V> implements Map<K,V>, Iterable{

    public static final int DEFAULT_TABLE_SIZE = 16;

    private Node[] table;
    private int size;
    private double loadFactor = 0.75;

    public MyHashMap() {
        table = new Node[DEFAULT_TABLE_SIZE];
    }

    public MyHashMap(int capacity){
        table = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        Node iter = table[position];
        while(iter != null){
            if(iter.key.equals(key)){
                return true;
            }
            iter = iter.next;
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        Iterator it = iterator();
        while (it.hasNext()) {
            Node tNode = (Node) it.next();
            if(tNode.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {

        if(!containsKey(key)){
            return null;
        }

        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        Node iter = table[position];
        while(iter != null){
            if(iter.key.equals(key)){
                return (V) iter.val;
            }
            iter = iter.next;
        }

        return null;
    }

    @Override// K must override hashCode and equals
    public V put(K key, V value) {

        if(containsKey(key)){
            // can not add
            // replace
        }

        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        if(table[position] == null){
            table[position] = new Node(key,value, null);
            size++;
        } else {
            Node iter = table[position];
            while(iter.next != null){
                iter = iter.next;
            }
            iter.next = new Node(key,value, null);
            size++;
        }

        return null;
    }

    @Override
    public V remove(Object key) {

        if(!containsKey(key)){
            return null;
        }

        int hash = key.hashCode();
        int position = Math.abs(hash % table.length);

        Node iter = table[position];
        Node previous = iter;

        while(iter != null){
            if(iter.key.equals(key)){
                if (iter == table[position]) {table[position] = iter.next;}
                else {previous.next = iter.next;};
                return (V) iter.val;
            }
            previous = iter;
            iter = iter.next;
            size--;
        }

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
    public Set<Entry<K, V>> entrySet() {

        return null;
    }

    //private static class MyHashMapTableIterator implements Iterator<Node>{
    private class MyHashMapTableIterator implements Iterator<Node>{

        //private Node curr;
        private Stack<Node> stack;

        public MyHashMapTableIterator() {
            stack = new Stack<Node>();
            for (int j= table.length-1; j>=0; j--)
            {
                if (table[j] != null) {
                    stack.push(table[j]);}
            }

        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Node next() {
            Node node = stack.pop();
            while (node.next != null)
            {
                 stack.push(node);
                 node = node.next;
            }

            return node;
        }
    }

    @Override
    public Iterator iterator() {
        return new MyHashMapTableIterator();
    }

    private static class Node implements Entry {

        Object key;
        Object val;
        Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return val;
        }

        @Override
        public Object setValue(Object value) {
            Object old = val;
            val = value;
            return old;
        }
    }
}

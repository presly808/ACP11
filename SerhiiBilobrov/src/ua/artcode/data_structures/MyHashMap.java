package ua.artcode.data_structures;

import java.util.*;

/**
 * Created by serhii on 06.12.15.
 */
public class MyHashMap<K,V> implements Map<K,V> {

    public static final int DEFAULT_TABLE_SIZE = 16;
    private double loadFactor = 0.75;
    private int size;

    private Node<K,V>[] table = new Node[DEFAULT_TABLE_SIZE];

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int bucketPlace = key.hashCode() % table.length;

        if(table[bucketPlace] == null){
            table[bucketPlace] = new Node<K,V>(key,value,null);
        } else {
            Node<K,V> iter = table[bucketPlace];

            while(iter.next != null){
                if(iter.key.equals(key)){
                    V last = iter.value;
                    iter.value = value;
                    return last;
                }
                iter = iter.next;
            }

            iter.next = new Node<K,V>(key,value,null);

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
        Iterator<Node<K,V>> nodeIterator = new NodeIterator();
        Collection<V> values = new ArrayList<>();

        for (Node<K, V> kvNode : table) {
            values.add(kvNode.value);
        }

        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class NodeIterator implements Iterator<Node<K,V>> {

        private int currentBucket;
        private Node<K,V> currentNode;

        public NodeIterator() {
            findFirstNotNull();
        }

        private void findFirstNotNull() {
            for (int i = 0; i < table.length; i++) {
                if(table[i] != null){
                    currentBucket = i;
                    currentNode = table[currentBucket];
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Node<K,V> next() {
            return null;
        }
    }

    public static class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> next;

        public Node(K key,V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

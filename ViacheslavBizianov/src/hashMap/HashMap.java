package hashMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashMap<K,V> implements Map<K,V> {

    private int DEFAULT_ARRAY_SIZE = 11;
    private Node<K,V>[] nodes;
    private final double loadFactor = 0.75;
    private int size;



    public HashMap() {
        this.nodes = new Node[DEFAULT_ARRAY_SIZE];
    }

    private class Node<K,V> implements Iterator{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return (next == null);
        }

        @Override
        public Object next() {
            return next;
        }


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
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
        int index = key.hashCode() % nodes.length;
        if (nodes[index] == null){
            nodes[index] = new Node(key, value, null);
            size++;
            return value;
        } else {
            Node<K,V> iter = nodes[index];
            while (iter.hasNext()){
                iter = iter.next;
            }
            V lastValue = iter.value;
            iter.next = new Node(key,value,null);
            return lastValue;
        }
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
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}

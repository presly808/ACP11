package week_01_home.dimahashmap;

import java.util.*;

/**
 * Created by dima on 08.12.2015.
 */
public class DimaHashMap<K,V> implements Map<K,V> {
    private final int DEFAULT_SIZE = 16;
    private int size = 0;

    private Node<K, V>[] nodes;

    public DimaHashMap() {
        this.nodes = new Node[DEFAULT_SIZE];
    }

    public DimaHashMap(int size) {
        this.nodes = (size > 0) ? new Node[size] : new Node[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
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
        if (key == null) {
            throw new NullPointerException("not allowed null value for key argument in DimaHashMap implementation");
        }

        int position = key.hashCode() % nodes.length;
        Node link = nodes[position];

        if (link != null) {
            // TODO is there ITERATOR for Node will be better solution or this way is enaugth?
            do {
                if ( !link.getKey().equals( (K)key ) ) {
                    link = link.getNext();
                } else {
                    return (V) link.getValue();
                }
            } while ( link.getNext() != null );
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("not allowed null value for key argument in DimaHashMap implementation");
        }

        int position = key.hashCode() % nodes.length; // the rest after division
        Node link = nodes[position];
        if (link == null) {
            nodes[position] = new Node(key, value, null);
            /////////////////////
            System.out.println(position + "ok " + value);
            return null;
        } else {

            do {
                System.out.println( link.getKey().equals( (K)key ) );
                //if (key.equals(link.getKey())) {
                if ( link.getKey().equals( (K)key ) ) {
                    //////////////////////
                    System.out.println(position + "ok " + value);
                    V oldValue = (V) link.getValue();
                    link.setValue(value);
                    return oldValue;
                }
                if ( link.getNext() != null ) {
                    link = link.getNext();
                }
            } while ( link.getNext() != null );

            //////////////////////////
            System.out.println(position + "ok " + value);
            link.setNext(new Node(key, value, null));

        }

        return null;
    }
/*
    public V putViaIterator(K key, V value) {
        if (key == null) {
            throw new NullPointerException("not allowed null value for key argument in DimaHashMap implementation");
        }

        int position = key.hashCode() % nodes.length; // the rest after division
        Node link = nodes[position];
        if (link == null) {
            nodes[position] = new Node(key, value, null);
            System.out.println(position + "ok " + value);
            return null;
        } else {
            for(Node n : link) {
                
            }

        }

        return null;
    }
*/
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

////////////////////////////
class Node<K,V> implements Iterable<Node> {
    private K key;
    private V value;
    private Node next;

    public Node(K key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public Iterator<Node> iterator() {
        Iterator<Node> itr = new Iterator<Node>() {
            @Override
            public boolean hasNext() {
                return getNext() != null;
            }

            @Override
            public Node next() {
                return getNext();
            }
        };

        return itr;
    }
}

////////////////////////////

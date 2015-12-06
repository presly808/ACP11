package tourniquet.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 06.12.2015.
 */
public class CardsTreeMap<K,V> implements Map<K,V> {

    private MapTreeNode root;
    private Comparator<K> keyComparator;

    public CardsTreeMap(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root != null;
    }

    @Override
    public boolean containsKey(Object key) {
        return find((K) key, root) != null;
    }

    @Override
    public boolean containsValue(Object value) {

        return false;
    }

    @Override
    public V get(Object key) {
        MapTreeNode found = find((K) key, root);

        return found != null ? found.entry.value : null;
    }

    private MapTreeNode find(K key,MapTreeNode current){

        if (current == null){
            return null;
        }

        int compareResult = keyComparator.compare(key, current.entry.key);

        if (compareResult < 0){
            return find(key,current.leftChild);
        } else if (compareResult < 0){
            return find(key,current.rightChild);
        } else {
            return current;
        }

    }

    @Override
    public V put(K key, V value) {

        MyEntry entry = new MyEntry(key,value);

        if (root == null){
            root = new MapTreeNode(entry,null,null,null);
            return null;
        }

        MapTreeNode iterator = root;

        while(iterator != null) {

            int compareResult = keyComparator.compare(key, iterator.entry.key);

            if (compareResult < 0) {
                if (iterator.leftChild == null) {
                    iterator.leftChild = new MapTreeNode(entry, root, null, null);
                    return null;
                } else {
                    iterator = iterator.leftChild;
                }
            } else if (compareResult > 0) {
                if (iterator.rightChild == null) {
                    iterator.rightChild = new MapTreeNode(entry, root, null, null);
                    return null;
                } else {
                    iterator = iterator.rightChild;
                }
            }
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
    public Set<Entry<K, V>> entrySet() {
        return null;
    }



    private class MapTreeNode {
        MyEntry entry;

        private MapTreeNode parent;
        private MapTreeNode leftChild;
        private MapTreeNode rightChild;

        public MapTreeNode(MyEntry entry, MapTreeNode parent, MapTreeNode leftChild, MapTreeNode rightChild) {
            this.entry = entry;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private class MyEntry{
        K key;
        V value;

        public MyEntry(K key, V vlaue) {
            this.key = key;
            this.value = vlaue;
        }
    }


}

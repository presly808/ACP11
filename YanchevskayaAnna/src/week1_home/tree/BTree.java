package week1_home.tree;

import java.util.Iterator;

/**
 *
 */
public interface BTree<T> extends Iterable {

    void add(T obj);

    boolean contains(T obj);

    boolean remove(T obj);

    int size();

    T findMin();

    T findMax();

    Iterator iterator();

}

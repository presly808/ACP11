package week1.binary_tree;

import java.util.NoSuchElementException;

/**
 * Created by 1 on 12.12.2015.
 */
public interface IBinaryTree<T> {

    void add(T o)throws ElementExistsException;

    T findMin() throws NoElementsInStructureException;

    T findMax() throws NoElementsInStructureException;

    boolean contains(T o);

    void delete(T o) throws NoSuchElementException;


    class ElementExistsException extends Exception {
    }

    class NoElementsInStructureException extends Exception {
    }
}

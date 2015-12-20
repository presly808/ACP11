package week1.binary_tree;


import week1.binary_tree.IBinaryTree;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 12.12.2015.
 */
public class BinaryTree<T> implements IBinaryTree<T> {

    TreeNode<T> root;
    Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinaryTree(Comparator<T> comparator, T...array) {
        this.comparator = comparator;

        for (T currentValue : array){
            try {
                add(currentValue);
            } catch (ElementExistsException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(T objectValue) throws ElementExistsException{

        if (root == null){
            root = new TreeNode<T>(objectValue,null,null,null);
            return;
        }

        TreeNode<T> iterator = root;

        while(iterator != null){

            int compareResult = comparator.compare(objectValue, iterator.value);

            if (compareResult < 0){
                if (iterator.leftChild == null){
                    iterator.leftChild = new TreeNode<T>(objectValue,iterator,null,null);
                    return;
                } else {
                    iterator = iterator.leftChild;
                }
            } else if (compareResult > 0){
                if (iterator.rightChild == null){
                    iterator.rightChild = new TreeNode<T>(objectValue,iterator,null,null);
                    return;
                } else {
                    iterator = iterator.rightChild;
                }
            } else {
                throw new ElementExistsException();
            }

        }

    }

    @Override
    public T findMin() throws NoElementsInStructureException{
        if (root == null){
            throw new NoElementsInStructureException();
        }

        TreeNode<T> iterator = root;

        while(iterator.leftChild != null){
            iterator = iterator.leftChild;
        }

        return iterator.value;
    }

    @Override
    public T findMax() throws NoElementsInStructureException{
        if (root == null){
            throw new NoElementsInStructureException();
        }

        TreeNode<T> iterator = root;

        while(iterator.rightChild != null){
            iterator = iterator.rightChild;
        }

        return iterator.value;
    }

    @Override
    public boolean contains(T o) {

        return findNode(o) != null;

    }

    private TreeNode<T> findNode(T o){

        TreeNode<T> iterator = root;

        while (iterator != null){

            int compareResult = comparator.compare(o,iterator.value);

            if (compareResult < 0){
                iterator = iterator.leftChild;
            } else  if (compareResult > 0){
                iterator = iterator.rightChild;
            } else {
                return iterator;
            }
        }

        return null;
    }

    @Override
    public void delete(T o) throws NoSuchElementException {
        TreeNode<T> node = findNode(o);
        if (node == null) {
            throw new NoSuchElementException();
        }

        if (node.parent == null){

            if (node.leftChild != null && node.rightChild != null) {
                root = node.rightChild;
                T min = null;
                try {
                    min = findMin();
                } catch (NoElementsInStructureException e) {
                    e.printStackTrace();
                }
                TreeNode<T> minNode = findNode(min);
                minNode.leftChild = node.leftChild;

            } else if (node.leftChild != null) {
                root = node.leftChild;
            } else if (node.rightChild != null) {
                root = node.rightChild;
            } else {
                root = null;
            }
        } else if (node == node.parent.leftChild){
            node.parent.leftChild = node.rightChild;

            // to finish!!

        } else if (node == node.parent.rightChild){
            node.parent.rightChild = node.rightChild;
            // to finish!!
        }


    }


    private class TreeNode<T>{

        T value;

        TreeNode<T> parent;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;

        public TreeNode(T value, TreeNode<T> parent, TreeNode<T> leftChild, TreeNode<T> rightChild) {
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}

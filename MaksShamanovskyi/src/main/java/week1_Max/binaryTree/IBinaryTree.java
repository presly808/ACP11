package week1_Max.binaryTree;

public interface IBinaryTree<E> extends Iterable<E> {

    boolean add(E element);

    boolean remove(E element);
}

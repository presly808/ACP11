package ua.artcode.week1_home.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

//import java.util.NoSuchElementException;


// declare generic -        use generic
public class BST<E> implements BTree<E>, Iterable {

    private TNode<E> root;
    private Comparator<E> comparator;
    private int size = 0;


    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(E obj) {
        if (root == null) {
            root = new TNode<E>(obj, null, null, null);
            size++;
        } else {
            TNode<E> iter = root;

            while (iter != null) {

                int compareRes = comparator.compare(obj, iter.value);
                if (compareRes < 0) {
                    if (iter.left == null) {
                        iter.left = new TNode<E>(obj, null, null, iter);
                        size++;
                        return;
                    } else {
                        iter = iter.left;
                    }
                } else if (compareRes > 0) {
                    if (iter.right == null) {
                        iter.right = new TNode<E>(obj, null, null, iter);
                        size++;
                        return;
                    } else {
                        iter = iter.right;
                    }
                }
            }
        }
    }

    @Override
    public boolean contains(E obj) {
        return find(obj, root) != null;
    }

    @Override
    public boolean remove(E key) {
        TNode current = root;
        TNode parent = root;
        int compareRes;
        boolean isLeftChild = true;

        while (current.value != key)
        {
            parent = current;
            compareRes = comparator.compare(key, (E) current.value);
            if (compareRes < 0)
            {
                isLeftChild = true;
                current = current.left;
            }
            else
            {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null)
                return  false;
        }
        // Если это листочек, т.е. у него нет потомков, он просто удаляется
        if ((current.left == null) && (current.right == null))
        {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.right == null)
        {
            if (current == root)
            root = current.left;
            else if (isLeftChild)
                parent.left = current.left;
            else parent.right = current.left;
        }
        // Если нет левого потомка, узел заменяется правым поддеревом
        else if (current.left == null)
        {
            if (current == root)
                root = current.right;
            else if (isLeftChild)
                parent.left = current.right;
            else parent.right = current.right;
        }
        else // Два потомка, узел заменяется преемником
        {
            //Поиск преемника для удаляемого узла
            TNode successor = getSuccessor (current);

            //Родитель current связывается с посредником
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;

            successor.left = current.left;
        }
        return  true;
    }

    //Метод возвращает узел со следующим значением после delNode.
    //Для этого он сначала переходит к правому потомку,
    // а затем отслеживает цепочку левых потомков этого узла
    private TNode<E> getSuccessor (TNode<E> delNode){
        TNode successorParent = delNode;
        TNode successor = delNode;
        TNode current = delNode.right; //Переход к правомк потомку
        while (current != null) //Пока остаются левые потомки
        {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != delNode.right) //Если преемник не является правым потомком, создать связи между узлами
        {
            successorParent.left = successor.right; //Правый узел преемника становится на место преемника
            successor.right = delNode.right; //правым узлом преемника становится правый узел ( и вся ветка) удаляемого узла
        }
        return  successor;
    }

    @Override
    public int size() {
        return size;
    }

    private String toString(TNode<E> node) {

        String res = "";

        if (node == null) {
            return "";
        }

        String left = toString(node.left);
        String me = node.value.toString() + ",";
        String right = toString(node.right);

        return left + me + right;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    public E findMin() {
       TNode current, last;
       current = root;
       last = root;
        while (current != null)
        {
            last = current;
            current = current.left;
        }
       return (E) last;
    }

    public E findMax() {
        TNode current, last;
        current = root;
        last = root;
        while (current != null)
        {
            last = current;
            current = current.right;
        }
        return (E) last;
    }

    private TNode<E> find(E el, TNode<E> iter) {

        if (iter == null) {
            return null;
        }

        int compareRes = comparator.compare(el, iter.value);

        if (compareRes < 0) {
            return find(el, iter.left);
        } else if (compareRes > 0) {
            return find(el, iter.right);
        }

        //return compareRes < 0 ? find(el, iter.left) : compareRes > 0 ? find(el, iter.left) : iter;

        return iter;
    }

    private static class TNode<X> {

        X value;
        TNode left;
        TNode right;
        TNode parent;

        public TNode(X value, TNode left,
                     TNode right, TNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }

     }

    public class BSTIterator implements Iterator {
        private Stack<TNode> stack;

        public BSTIterator() {
            TNode position = root;
            stack = new Stack<TNode>();
            while (position != null) {
                stack.push(position);
                position = position.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public E next() {
            TNode node = stack.pop();
            E result = (E) node.value;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }

    @Override
    public Iterator iterator() {
        return new BSTIterator();
    }
}

package week1.binaryTree;

<<<<<<< HEAD
import java.util.Iterator;
=======
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
>>>>>>> b3f71e0d3b4ac98337cb1878daaa8c00e7ba2a47

public class TestBinaryTree {
    public static void main(String[] args) {
        IBinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(20);
        tree.add(30);
        tree.add(15);
        tree.add(16);
        tree.add(9);
        tree.add(12);
        tree.add(7);
        tree.add(8);
        tree.add(13);

<<<<<<< HEAD
        Iterator iter = tree.getIterator();
        Object[] mas = new Object[9];
        mas[0] = iter.next();
        mas[1] = iter.next();
        mas[2] = iter.next();
        mas[3] = iter.next();
        mas[4] = iter.next();
        mas[5] = iter.next();
        mas[6] = iter.next();
        mas[7] = iter.next();
        mas[8] = iter.next();
        System.out.println(iter.hasNext());
=======
        Iterator<Integer> iter = tree.iterator();

        //Object[] mas = new Object[9];

        List<Integer> arr = new ArrayList<>();
        while(iter.hasNext()){
            arr.add(iter.next());
        }


        for (Integer integer : arr) {
            System.out.println(integer);
        }
>>>>>>> b3f71e0d3b4ac98337cb1878daaa8c00e7ba2a47
    }
}

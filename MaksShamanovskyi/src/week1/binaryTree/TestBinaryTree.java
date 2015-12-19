package week1.binaryTree;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

>>>>>>> edeceefe24c415f48a385387fb1a94e96fb2d57a
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
>>>>>>> edeceefe24c415f48a385387fb1a94e96fb2d57a
    }
}

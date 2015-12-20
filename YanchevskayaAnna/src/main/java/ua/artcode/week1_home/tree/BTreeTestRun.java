package ua.artcode.week1_home.tree;

/**
 * Created by serhii on 25.09.15.
 */
public class BTreeTestRun {

    public static void main(String[] args) {
        BTreeTest test = new BTreeTest();
        test.start();

        // arg    body
        // () -> {}
        /*BTree<Integer> bTree1 = new BST<>((Integer i1,Integer i2) -> {return i1 - i2;});
        BTree<String> bTree2 = new BST<>(String::compareTo);

        bTree1.add(50);
        bTree1.add(25);
        bTree1.add(30);
        bTree1.add(75);
        bTree1.add(10);
        bTree1.add(70);
        bTree1.add(80);

       System.out.println(bTree1.toString());*/
    }
}

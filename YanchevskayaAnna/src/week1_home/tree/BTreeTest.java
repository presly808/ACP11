package week1_home.tree;

import java.util.Comparator;
import java.util.Iterator;


public class BTreeTest {

    private BTree<Integer> bTree = null;

    public BTreeTest() {

        bTree = new BST<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    private void testSimpleAdd(){

        bTree.add(100);
        bTree.add(80);
        bTree.add(120);
        bTree.add(70);
        bTree.add(90);
        bTree.add(60);
        bTree.add(75);
        bTree.add(50);
        bTree.add(85);
        bTree.add(95);
        bTree.add(110);
        bTree.add(140);

        if(bTree.size() != 12){
            System.out.println("Test add failed");
        } else {
            System.out.println("Test add success");
        }

    }

    private void testContains(){
        bTree.add(88);
        if(bTree.contains(88)){
            System.out.println("Test contains success");
        } else {
            System.out.println("Test contains failed");
        }
    }

    private void testPrint(){

        System.out.println("Test print: " + bTree);

    }

    private void testRemove(){

        bTree.remove(60);

        System.out.println("Test remove 60:" + bTree);

        bTree.remove(90); //Не работает удаление

        System.out.println("Test remove 90:" +bTree);

    }

    private void testIterator(){

         //Проверка итератора 1
        System.out.println("Test iterator foreach: " + bTree);
        for (Object obj : bTree) {
            System.out.println("Элемент " + obj);
        }

        //Проверка итератора 2
        System.out.println("Test iterator(): " +bTree);
        Iterator it = bTree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    private void testMinMax(){
        System.out.println("Мин: "  + bTree.findMin());
        System.out.println("Макс: " + bTree.findMax());
    }

    public void start(){
        testSimpleAdd();
        testContains();
        testPrint();
        testRemove();
        testIterator();
        testMinMax();
    }



}

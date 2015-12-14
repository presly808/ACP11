package week2;

public class TestScanner {
    public static void main(String[] args) {
        String text = "some text for example";
        IScanner scanner = new MyScanner(text);

//        if (scanner.next().equals("some")) {
//            System.out.println("next is working");
//        } else {
//            System.out.println(false);
//        }
//
//        if (scanner.next().equals("text")) {
//            System.out.println("next is working");
//        } else {
//            System.out.println(false);
//        }
//
//        if (scanner.nextLine().equals("for example")) {
//            System.out.println("nextLine is working");
//
//        } else {
//            System.out.println(false);
//        }

        System.out.println(scanner.nextLine());


    }
}

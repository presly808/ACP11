package week2;

public class TestScanner {
    public static void main(String[] args) {

        IScanner scanner = new MyScanner("some text for example");

        System.out.println(scanner.hasNext() ?  "hasNext is working" : "false");
        System.out.println(scanner.next().equals("some") ?  "next is working" : "false");
        System.out.println(scanner.hasNext() ?  "hasNext is working" : "false");
        System.out.println(scanner.next().equals("text") ?  "next is working" : "false");
        System.out.println(scanner.nextLine().equals("for example") ?  "nextLine is working" : "false");
        System.out.println(scanner.hasNext() ?  "something wrong" : "hasNext is working");

        System.out.println("**************************");
        IScanner scanner1 = new MyScanner("0123546789 text");
        System.out.println(scanner1.hasNextInt() ?  "hasNext is working" : "false");
        System.out.println(scanner1.nextInt() == 123546 ?  "nextInt is working" : "false");
        System.out.println(scanner1.hasNextInt() ?  "something wrong" : "hasNextInt is working");



    }
}

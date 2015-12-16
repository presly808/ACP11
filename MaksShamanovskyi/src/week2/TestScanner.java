package week2;

public class TestScanner {
    public static void main(String[] args) {

        //todo wxtract test logic to junit test
        IScanner scanner = new MyScanner("some text for example");

        System.out.println(scanner.hasNext() ?  "hasNext is working" : "false");
        System.out.println(scanner.next().equals("some") ?  "next is working" : "false");
        System.out.println(scanner.hasNext() ?  "hasNext is working" : "false");
        System.out.println(scanner.next().equals("text") ?  "next is working" : "false");
        System.out.println(scanner.nextLine().equals("for example") ?  "nextLine is working" : "false");
        System.out.println(scanner.hasNext() ?  "something wrong" : "hasNext is working");

        System.out.println("**************************");
        IScanner scanner1 = new MyScanner("1234567890 text");
        System.out.println(scanner1.hasNextInt() ?  "hasNext is working" : "false");
        System.out.println(scanner1.nextInt() == 1234567890 ?  "nextInt is working" : "false");
        System.out.println(scanner1.hasNextInt() ?  "something wrong" : "hasNextInt is working");



    }
}

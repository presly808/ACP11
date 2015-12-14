package week2;

public class TestScanner {
    public static void main(String[] args) {
        String text = "some text";
        IScanner scanner = new MyScanner(text);

        if (scanner.nextLine().equals(text)) {
            System.out.println("nextLine is working");

        } else {
            System.out.println(false);
        }

        if (scanner.hasNext()) {
            System.out.println("has next");
            if (scanner.next().equals(text)) {
                System.out.println("next is working");

            } else {
                System.out.println(false);
            }
        } else {
            System.out.println(false);
        }
        text = "123 333";
        if (scanner.hasNextInt()) {
            System.out.println("has nextInt");
            if (scanner.next().equals(text)) {
                System.out.println("nextInt is working");
            } else {
                System.out.println(false);
            }
        } else {
            System.out.println(false);
        }
    }
}

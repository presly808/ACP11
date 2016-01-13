package week_02_home.my_scanner;

import java.io.Reader;

/**
 * Created by Dima on 15.12.2015.
 */
public class TestMyScanner {

    public static void main(String[] args) {

        String testString = "test string for MyScanner test. \n this test string contains the digits like 333, 555, 999. and the delimiters like this -, \n. And the lenght of th, is string by default i, s bigger than scanner buffer size";
        MyScanner msc = new MyScanner( testString );

        System.out.println("the test string is: \n" + testString);

        if( msc.hasNext() == true ) {
            System.out.println("MyScanner.hasNext() method\t\t\tOk");
        } else {
            System.out.println("MyScanner.hasNext() method\t\t\tFail!");
        }

        if ( msc.hasNextInt() == true ) {
            System.out.println("MyScanner.hasNextInt() method\t\t\tOk");
        } else {
            System.out.println("MyScanner.hasNextInt() method\t\t\tFail!");
        }

        if ( "t".equals(msc.next()) )  {
            if ( "e".equals(msc.next()) ) {
                System.out.println("MyScanner.next() method\t\t\tOk");
            } else {
                System.out.println("MyScanner.next() method\t\t\tFail!");
            }
        } else {
            System.out.println("MyScanner.next() method\t\t\tFail!");
        }

        if ( msc.nextInt() == 333 )  {
            if ( msc.nextInt() == 555 ) {
                System.out.println("MyScanner.nextInt() method\t\t\tOk");
            } else {
                System.out.println("MyScanner.nextInt() method\t\t\tFail!");
            }
        } else {
            System.out.println("MyScanner.nextInt() method\t\t\tFail!");
        }

        if ( "test string for MyScanner test. ".equals(msc.nextLine()) ) {
            if ( " this test string contains the digits like 333, 555, 999. and the delimiters like this -, ".equals(msc.nextLine()) ) {
                System.out.println("MyScanner.next() method\t\t\tOk");
            } else {
                System.out.println("MyScanner.next() method\t\t\tFail!");
            }
        } else {
            System.out.println("MyScanner.next() method\t\t\tFail!");
        }

        System.out.println("change default delimiter '\\n' to ','\t\t\tOk");
        msc.useDelimiter(",");

        if ( ". And the lenght of th".equals(msc.nextLine()) ) {
            if ( " is string by default i".equals(msc.nextLine()) ) {
                System.out.println("MyScanner.next() method\t\t\tOk");
            } else {
                System.out.println("MyScanner.next() method\t\t\tFail!");
            }
        } else {
            System.out.println("MyScanner.next() method\t\t\tFail!");
        }

        System.out.println("Closing the scanner\t\t\tOk.");
        msc.close();

        try {
            msc.hasNext();
            System.out.println("The scaner was not closed\t\t\tFail!");
        } catch (Exception e) {
            System.out.println("the scanner was closed successfully:\t\t\t" + e.toString());
        }

    }

}

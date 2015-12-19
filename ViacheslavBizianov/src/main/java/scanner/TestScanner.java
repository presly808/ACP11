package scanner;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TestScanner {
    public static void main(String[] args) throws IOException {

        Scanner scanner1 = new Scanner(
                                new FileReader(
                                    new File("C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\test.txt")));

        Scanner scanner2 = new Scanner("Ukraine is independent country since 1991");

        if (scanner1.next().equals("viacheslav")){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner1.hasNext() == true){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner1.nextInt() == 2){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner1.nextInt() == 7){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner1.hasNext() == false){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner2.next().equals("Ukraine")){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner2.nextInt() == 1){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        if (scanner2.nextInt() == 9){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

    }


}

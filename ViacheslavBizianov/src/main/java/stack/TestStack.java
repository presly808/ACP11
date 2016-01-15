package stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestStack {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();

        String input = getString();

        stack.bracketChecker(input);

    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String s = bf.readLine();
        return s;
    }

}

package week2;

import java.util.Scanner;

public interface IScanner{

    String nextLine();

    String next();

    int nextInt();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String delimiter);

    void close();
}

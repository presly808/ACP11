package week2;

/**
 * Created by 1 on 18.12.2015.
 */
public interface IScanner {

    String next();

    String nextLine();

    int nextInt();

    double nextDouble();

    boolean hasNext();

    boolean hasNextInt();

    boolean hasNextDouble();

    void close();
}

package main.week2;

public interface IScanner{

    String nextLine();

    String next();

    int nextInt();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String delimiter);

    void close();
}

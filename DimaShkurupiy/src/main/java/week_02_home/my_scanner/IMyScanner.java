package week_02_home.my_scanner;

/**
 * Created by Dima on 15.12.2015.
 */
public interface IMyScanner {

    // constructor ( String )

    // constructor ( Reader )

    public String next();

    public int nextInt();

    public String nextLine();

    public boolean hasNext();

    public boolean hasNextInt();

    public void useDelimiter(String delimiter);

    public void close();
}

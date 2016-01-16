package week5_Max.fileSearch;

public class TestFileSearchers {
    public static void main(String[] args) {
        ThreadPoolSearch thSeacher =
                new ThreadPoolSearch(System.getProperty("user.home"), 20, "Helper");
        thSeacher.search();
        System.out.println("-----------------------------------------------");

        BreadthFirstSearch bfs =
                new BreadthFirstSearch(System.getProperty("user.home"), "Helper");
        bfs.search();
    }
}

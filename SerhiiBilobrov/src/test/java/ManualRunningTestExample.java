import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by serhii on 19.12.15.
 */
public class ManualRunningTestExample {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestScanner.class);
        System.out.println(result.wasSuccessful());
    }
}

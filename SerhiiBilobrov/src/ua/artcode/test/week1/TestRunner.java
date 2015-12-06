package ua.artcode.test.week1;

import java.util.List;

/**
 * Created by serhii on 06.12.15.
 */
public class TestRunner {

    public static String runTests(AbstractTest[] abstractTest){
        StringBuilder sb = new StringBuilder();
        for (AbstractTest test : abstractTest) {
            test.startAllTests();
            sb.append(test.showTestResults()).append("\n");
        }

        return sb.toString();
    }


}

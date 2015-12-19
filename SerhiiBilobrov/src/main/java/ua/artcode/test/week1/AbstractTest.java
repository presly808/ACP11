package ua.artcode.test.week1;

import java.util.List;

/**
 * Created by serhii on 06.12.15.
 */
public abstract class AbstractTest {

    protected List<TestResult> testResultList;

    public abstract void startAllTests();

    public String showTestResults(){
        String res = "";
        for (TestResult testResult : testResultList) {
            res += testResult + "\n";
        }
        return res;
    }
}

package ua.artcode.test.week1;


public class TestResult {

    private String testName;
    private String in;
    private String expected;
    private String actual;

    private boolean passed;

    public TestResult(String testName, String in,
                      String expected, String actual) {
        this.testName = testName;
        this.in = in;
        this.expected = expected;
        this.actual = actual;

        this.passed = expected.equals(actual);
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "testName='" + testName + '\'' +
                ", in='" + in + '\'' +
                ", expected='" + expected + '\'' +
                ", actual='" + actual + '\'' +
                ", passed=" + passed +
                '}';
    }
}

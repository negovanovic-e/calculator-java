public class CalculatorUnitTest {

    public static void main(String[] args) {
        testCalculateRespectsOperatorPrecedence();
    }

    private static void testCalculateRespectsOperatorPrecedence() {
        String expression = "10+5*4+3";
        String expected = "33.0";
        String actual = Calculator.Run(expression);

        if (!expected.equals(actual)) {
            throw new AssertionError(
                "Izraz: " + expression
                + "; očekivano: " + expected
                + "; dobiveno: " + actual
            );
        }

        System.out.println("PASS: testCalculateRespectsOperatorPrecedence");
    }
}

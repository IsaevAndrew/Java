package Practice_31;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialCalculatorTest {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();

        long result = calculator.calculateFactorial(5);

        assertEquals(120, result);
    }

    @Test
    public void testCalculateFactorialWithZero() {
        FactorialCalculator calculator = new FactorialCalculator();
        long result = calculator.calculateFactorial(0);
        assertEquals(1, result);
    }

    @Test
    public void testCalculateFactorialWithNegativeNumber() {
        FactorialCalculator calculator = new FactorialCalculator();

        try {
            long result = calculator.calculateFactorial(-5);
        } catch (IllegalArgumentException e) {
            assertEquals("Input must be a non-negative integer", e.getMessage());
        }
    }
}

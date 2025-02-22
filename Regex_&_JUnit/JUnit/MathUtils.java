import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtils {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

class MathUtilsTest {
    private final MathUtils mathUtils = new MathUtils();

    @Test
    void testDivide() {
        assertEquals(2, mathUtils.divide(6, 3));
        assertEquals(-3, mathUtils.divide(-9, 3));
        assertEquals(0, mathUtils.divide(0, 5));
    }

    @Test
    void testDivideByZeroException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

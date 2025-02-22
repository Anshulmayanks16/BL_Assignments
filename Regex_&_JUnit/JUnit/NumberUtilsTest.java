import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class NumberUtilsTest {
    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 9, 11})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd");
    }
}

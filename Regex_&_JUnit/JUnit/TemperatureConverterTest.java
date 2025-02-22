import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

class TemperatureConverterTest {
    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.01);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.01);
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.01);
    }
}

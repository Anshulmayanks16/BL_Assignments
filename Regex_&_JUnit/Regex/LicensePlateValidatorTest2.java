import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class LicensePlateValidator {
    private static final String LICENSE_PLATE_REGEX = "^[A-Z]{2}\\d{4}$";
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile(LICENSE_PLATE_REGEX);

    public boolean isValidLicensePlate(String plate) {
        if (plate == null) return false;
        return LICENSE_PLATE_PATTERN.matcher(plate).matches();
    }
}

class LicensePlateValidatorTest {
    private final LicensePlateValidator validator = new LicensePlateValidator();

    @Test
    void testValidLicensePlates() {
        assertTrue(validator.isValidLicensePlate("AB1234"), "Valid license plate should pass.");
        assertTrue(validator.isValidLicensePlate("XY9876"), "Valid license plate should pass.");
    }

    @Test
    void testInvalidLicensePlates() {
        assertFalse(validator.isValidLicensePlate("A12345"), "License plate with one letter should be invalid.");
        assertFalse(validator.isValidLicensePlate("ABC123"), "License plate with three letters should be invalid.");
        assertFalse(validator.isValidLicensePlate("AB12"), "License plate with fewer than four digits should be invalid.");
        assertFalse(validator.isValidLicensePlate("ab1234"), "License plate with lowercase letters should be invalid.");
        assertFalse(validator.isValidLicensePlate("AB12345"), "License plate with more than four digits should be invalid.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidLicensePlate(null), "Null input should be invalid.");
        assertFalse(validator.isValidLicensePlate(""), "Empty input should be invalid.");
    }
}

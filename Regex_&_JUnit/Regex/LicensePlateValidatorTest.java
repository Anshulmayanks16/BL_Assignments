import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class LicensePlateValidator {
    private static final String LICENSE_PLATE_REGEX = "^[A-Z]{2}\\d{4}$";

    public boolean isValidLicensePlate(String plate) {
        return plate != null && Pattern.matches(LICENSE_PLATE_REGEX, plate);
    }
}

class LicensePlateValidatorTest {
    private final LicensePlateValidator validator = new LicensePlateValidator();

    @Test
    void testValidLicensePlates() {
        assertTrue(validator.isValidLicensePlate("AB1234"), "Valid format");
        assertTrue(validator.isValidLicensePlate("XY9876"), "Valid format");
    }

    @Test
    void testInvalidLicensePlates() {
        assertFalse(validator.isValidLicensePlate("A12345"), "Should be invalid: starts with one letter");
        assertFalse(validator.isValidLicensePlate("ABC123"), "Should be invalid: starts with three letters");
        assertFalse(validator.isValidLicensePlate("AB123"), "Should be invalid: only three digits");
        assertFalse(validator.isValidLicensePlate("AB12345"), "Should be invalid: five digits");
        assertFalse(validator.isValidLicensePlate("ab1234"), "Should be invalid: lowercase letters");
        assertFalse(validator.isValidLicensePlate("AB12A4"), "Should be invalid: contains a letter in digits");
        assertFalse(validator.isValidLicensePlate(null), "Should be invalid: null input");
        assertFalse(validator.isValidLicensePlate(""), "Should be invalid: empty string");
    }
}

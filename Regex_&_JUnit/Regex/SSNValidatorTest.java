import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.*;

class SSNValidator {
    private static final String SSN_REGEX = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

    public boolean isValidSSN(String ssn) {
        if (ssn == null) return false;
        return Pattern.matches(SSN_REGEX, ssn);
    }
}

class SSNValidatorTest {
    private final SSNValidator validator = new SSNValidator();

    @Test
    void testValidSSN() {
        assertTrue(validator.isValidSSN("123-45-6789"), "Valid SSN should return true.");
    }

    @Test
    void testInvalidSSN_MissingDashes() {
        assertFalse(validator.isValidSSN("123456789"), "SSN without dashes should be invalid.");
    }

    @Test
    void testInvalidSSN_WrongFormat() {
        assertFalse(validator.isValidSSN("123-456-789"), "SSN with incorrect format should be invalid.");
    }

    @Test
    void testInvalidSSN_Alphabets() {
        assertFalse(validator.isValidSSN("ABC-DE-FGHI"), "SSN with letters should be invalid.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidSSN(null), "Null input should return false.");
        assertFalse(validator.isValidSSN(""), "Empty input should return false.");
    }
}

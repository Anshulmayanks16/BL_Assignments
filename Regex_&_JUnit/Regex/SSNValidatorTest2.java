import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class SSNValidator {
    private static final String SSN_REGEX = "^(\\d{3}-\\d{2}-\\d{4})$";
    private static final Pattern SSN_PATTERN = Pattern.compile(SSN_REGEX);

    public boolean isValidSSN(String ssn) {
        if (ssn == null) return false;
        return SSN_PATTERN.matcher(ssn).matches();
    }
}

class SSNValidatorTest {
    private final SSNValidator validator = new SSNValidator();

    @Test
    void testValidSSN() {
        assertTrue(validator.isValidSSN("123-45-6789"), "SSN with correct format should be valid.");
    }

    @Test
    void testInvalidSSN() {
        assertFalse(validator.isValidSSN("123456789"), "SSN without dashes should be invalid.");
        assertFalse(validator.isValidSSN("123-456-789"), "SSN with incorrect format should be invalid.");
        assertFalse(validator.isValidSSN("12-345-6789"), "SSN with incorrect group lengths should be invalid.");
        assertFalse(validator.isValidSSN("abc-de-fghi"), "SSN with non-numeric characters should be invalid.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidSSN(null), "Null input should be invalid.");
        assertFalse(validator.isValidSSN(""), "Empty input should be invalid.");
    }
}

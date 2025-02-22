import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class SSNValidator {
    private static final String SSN_REGEX = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

    public boolean isValidSSN(String ssn) {
        return Pattern.matches(SSN_REGEX, ssn);
    }
}

class SSNValidatorTest {
    private final SSNValidator validator = new SSNValidator();

    @Test
    void testValidSSN() {
        assertTrue(validator.isValidSSN("123-45-6789"));
    }

    @Test
    void testInvalidSSN_NoDashes() {
        assertFalse(validator.isValidSSN("123456789"));
    }

    @Test
    void testInvalidSSN_WrongFormat() {
        assertFalse(validator.isValidSSN("123-456-789"));
    }

    @Test
    void testInvalidSSN_ShortLength() {
        assertFalse(validator.isValidSSN("12-345-6789"));
    }

    @Test
    void testInvalidSSN_ExtraCharacters() {
        assertFalse(validator.isValidSSN("123-45-6789x"));
    }
}

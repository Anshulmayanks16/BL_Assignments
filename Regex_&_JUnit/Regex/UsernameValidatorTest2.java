import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class UsernameValidator {
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    public boolean isValidUsername(String username) {
        if (username == null) return false;
        return USERNAME_PATTERN.matcher(username).matches();
    }
}

class UsernameValidatorTest {
    private final UsernameValidator validator = new UsernameValidator();

    @Test
    void testValidUsernames() {
        assertTrue(validator.isValidUsername("user_123"), "Valid username should pass.");
        assertTrue(validator.isValidUsername("Alice_99"), "Valid username should pass.");
        assertTrue(validator.isValidUsername("JohnDoe_"), "Valid username should pass.");
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(validator.isValidUsername("123user"), "Username starting with a number should be invalid.");
        assertFalse(validator.isValidUsername("us"), "Username too short should be invalid.");
        assertFalse(validator.isValidUsername("veryLongUsername123"), "Username too long should be invalid.");
        assertFalse(validator.isValidUsername("user@name"), "Username with special characters should be invalid.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidUsername(null), "Null input should be invalid.");
        assertFalse(validator.isValidUsername(""), "Empty input should be invalid.");
    }
}

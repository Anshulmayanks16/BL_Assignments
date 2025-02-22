import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class UsernameValidator {
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

    public boolean isValidUsername(String username) {
        return username != null && Pattern.matches(USERNAME_REGEX, username);
    }
}

class UsernameValidatorTest {
    private final UsernameValidator validator = new UsernameValidator();

    @Test
    void testValidUsernames() {
        assertTrue(validator.isValidUsername("user_123"));
        assertTrue(validator.isValidUsername("User_99"));
        assertTrue(validator.isValidUsername("A_very_long1"));
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(validator.isValidUsername("123user"), "Should be invalid: starts with a number");
        assertFalse(validator.isValidUsername("us"), "Should be invalid: too short");
        assertFalse(validator.isValidUsername("username_too_long_123"), "Should be invalid: too long");
        assertFalse(validator.isValidUsername("user@name"), "Should be invalid: contains special character '@'");
        assertFalse(validator.isValidUsername(""), "Should be invalid: empty string");
        assertFalse(validator.isValidUsername(null), "Should be invalid: null input");
    }
}

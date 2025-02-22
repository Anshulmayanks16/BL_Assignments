import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false, hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasUpperCase && hasDigit;
    }
}

class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPasswords() {
        assertTrue(validator.isValid("Strong1Password"), "Should be valid");
        assertTrue(validator.isValid("A1bcdefgh"), "Should be valid");
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(validator.isValid("short1"), "Too short");
        assertFalse(validator.isValid("nouppercase1"), "Missing uppercase");
        assertFalse(validator.isValid("NOLOWERCASE1"), "Missing lowercase");
        assertFalse(validator.isValid("NoDigitHere"), "Missing digit");
        assertFalse(validator.isValid(null), "Null password should be invalid");
    }
}

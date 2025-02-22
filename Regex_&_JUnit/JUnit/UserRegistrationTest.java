import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}

class UserRegistrationTest {
    private final UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("JohnDoe", "john@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john@example.com", "Password1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "invalid-email", "Password1"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john@example.com", "short"));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }
}

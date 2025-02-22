import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class HexColorValidator {
    private static final String HEX_COLOR_REGEX = "^#[0-9A-Fa-f]{6}$";
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile(HEX_COLOR_REGEX);

    public boolean isValidHexColor(String color) {
        if (color == null) return false;
        return HEX_COLOR_PATTERN.matcher(color).matches();
    }
}

class HexColorValidatorTest {
    private final HexColorValidator validator = new HexColorValidator();

    @Test
    void testValidHexColors() {
        assertTrue(validator.isValidHexColor("#FFA500"), "Valid hex color should pass.");
        assertTrue(validator.isValidHexColor("#ff4500"), "Valid hex color should pass.");
        assertTrue(validator.isValidHexColor("#00FF00"), "Valid hex color should pass.");
    }

    @Test
    void testInvalidHexColors() {
        assertFalse(validator.isValidHexColor("#123"), "Too short hex color should be invalid.");
        assertFalse(validator.isValidHexColor("FFA500"), "Missing # should be invalid.");
        assertFalse(validator.isValidHexColor("#GHIJKL"), "Invalid characters should be invalid.");
        assertFalse(validator.isValidHexColor("#1234567"), "Too long hex color should be invalid.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidHexColor(null), "Null input should be invalid.");
        assertFalse(validator.isValidHexColor(""), "Empty input should be invalid.");
    }
}

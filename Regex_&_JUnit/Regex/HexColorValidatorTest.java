import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class HexColorValidator {
    private static final String HEX_COLOR_REGEX = "^#[A-Fa-f0-9]{6}$";

    public boolean isValidHexColor(String color) {
        return color != null && Pattern.matches(HEX_COLOR_REGEX, color);
    }
}

class HexColorValidatorTest {
    private final HexColorValidator validator = new HexColorValidator();

    @Test
    void testValidHexColors() {
        assertTrue(validator.isValidHexColor("#FFA500"), "Valid color: uppercase hex");
        assertTrue(validator.isValidHexColor("#ff4500"), "Valid color: lowercase hex");
        assertTrue(validator.isValidHexColor("#00FF00"), "Valid color: green");
    }

    @Test
    void testInvalidHexColors() {
        assertFalse(validator.isValidHexColor("FFA500"), "Should be invalid: missing #");
        assertFalse(validator.isValidHexColor("#123"), "Should be invalid: too short");
        assertFalse(validator.isValidHexColor("#GHIJKL"), "Should be invalid: non-hex characters");
        assertFalse(validator.isValidHexColor("#1234567"), "Should be invalid: too long");
        assertFalse(validator.isValidHexColor("##FFA500"), "Should be invalid: double #");
        assertFalse(validator.isValidHexColor(""), "Should be invalid: empty string");
        assertFalse(validator.isValidHexColor(null), "Should be invalid: null input");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class IPAddressValidator {
    private static final String IP_REGEX = 
        "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" + 
        "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

    private static final Pattern pattern = Pattern.compile(IP_REGEX);

    public boolean isValidIP(String ip) {
        if (ip == null) return false;
        return pattern.matcher(ip).matches();
    }
}

class IPAddressValidatorTest {
    private final IPAddressValidator validator = new IPAddressValidator();

    @Test
    void testValidIPs() {
        assertTrue(validator.isValidIP("192.168.1.1"));
        assertTrue(validator.isValidIP("255.255.255.255"));
        assertTrue(validator.isValidIP("0.0.0.0"));
        assertTrue(validator.isValidIP("127.0.0.1"));
    }

    @Test
    void testInvalidIPs() {
        assertFalse(validator.isValidIP("256.100.100.100")); // Out of range
        assertFalse(validator.isValidIP("192.168.1")); // Missing part
        assertFalse(validator.isValidIP("192.168.1.1.1")); // Extra part
        assertFalse(validator.isValidIP("192.168.01.1")); // Leading zero
        assertFalse(validator.isValidIP("abc.def.ghi.jkl")); // Non-numeric
        assertFalse(validator.isValidIP("192.168.-1.1")); // Negative number
    }

    @Test
    void testNullAndEmpty() {
        assertFalse(validator.isValidIP(null), "Null input should return false");
        assertFalse(validator.isValidIP(""), "Empty string should return false");
    }
}

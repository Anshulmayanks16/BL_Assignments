import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IPAddressValidator {
    private static final String IPV4_REGEX = 
        "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

    public boolean isValidIPv4(String ip) {
        return ip != null && ip.matches(IPV4_REGEX);
    }
}

class IPAddressValidatorTest {
    private final IPAddressValidator validator = new IPAddressValidator();

    @Test
    void testValidIPv4Addresses() {
        assertTrue(validator.isValidIPv4("192.168.1.1"), "Should be valid");
        assertTrue(validator.isValidIPv4("255.255.255.255"), "Should be valid");
        assertTrue(validator.isValidIPv4("0.0.0.0"), "Should be valid");
        assertTrue(validator.isValidIPv4("127.0.0.1"), "Should be valid");
    }

    @Test
    void testInvalidIPv4Addresses() {
        assertFalse(validator.isValidIPv4("256.100.100.100"), "256 is out of range");
        assertFalse(validator.isValidIPv4("192.168.1"), "Missing octet");
        assertFalse(validator.isValidIPv4("192.168.1.999"), "999 is out of range");
        assertFalse(validator.isValidIPv4("192.168.01.1"), "Leading zero not allowed");
        assertFalse(validator.isValidIPv4("abc.def.ghi.jkl"), "Not numbers");
        assertFalse(validator.isValidIPv4("192.168.-1.1"), "Negative numbers are invalid");
        assertFalse(validator.isValidIPv4("192.168.1.1.1"), "Too many octets");
    }

    @Test
    void testNullAndEmptyStrings() {
        assertFalse(validator.isValidIPv4(null), "Null should be invalid");
        assertFalse(validator.isValidIPv4(""), "Empty string should be invalid");
    }
}

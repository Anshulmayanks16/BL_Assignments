import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class IPAddressValidator {
    private static final String IP_REGEX =
        "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." + 
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." + 
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." + 
        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

    private static final Pattern IP_PATTERN = Pattern.compile(IP_REGEX);

    public boolean isValidIPAddress(String ip) {
        return ip != null && IP_PATTERN.matcher(ip).matches();
    }
}

class IPAddressValidatorTest {
    private final IPAddressValidator validator = new IPAddressValidator();

    @Test
    void testValidIPAddresses() {
        assertTrue(validator.isValidIPAddress("192.168.1.1"));
        assertTrue(validator.isValidIPAddress("0.0.0.0"));
        assertTrue(validator.isValidIPAddress("255.255.255.255"));
        assertTrue(validator.isValidIPAddress("127.0.0.1"));
    }

    @Test
    void testInvalidIPAddresses() {
        assertFalse(validator.isValidIPAddress("256.256.256.256"), "Out of range values.");
        assertFalse(validator.isValidIPAddress("192.168.1"), "Missing octet.");
        assertFalse(validator.isValidIPAddress("192.168.1.256"), "Octet out of range.");
        assertFalse(validator.isValidIPAddress("192.168.1.01"), "Leading zero.");
        assertFalse(validator.isValidIPAddress("192.168..1"), "Consecutive dots.");
        assertFalse(validator.isValidIPAddress("192.168.1.1.1"), "Extra octet.");
        assertFalse(validator.isValidIPAddress("abc.def.ghi.jkl"), "Non-numeric input.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidIPAddress(null), "Null input should be invalid.");
        assertFalse(validator.isValidIPAddress(""), "Empty input should be invalid.");
    }
}

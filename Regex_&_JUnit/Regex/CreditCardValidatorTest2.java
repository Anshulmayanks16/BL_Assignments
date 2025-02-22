import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class CreditCardValidator {
    private static final String VISA_REGEX = "^4\\d{15}$"; // Starts with 4, 16 digits
    private static final String MASTERCARD_REGEX = "^5\\d{15}$"; // Starts with 5, 16 digits

    private static final Pattern VISA_PATTERN = Pattern.compile(VISA_REGEX);
    private static final Pattern MASTERCARD_PATTERN = Pattern.compile(MASTERCARD_REGEX);

    public boolean isValidCreditCard(String cardNumber) {
        if (cardNumber == null) return false;
        return VISA_PATTERN.matcher(cardNumber).matches() || MASTERCARD_PATTERN.matcher(cardNumber).matches();
    }
}

class CreditCardValidatorTest {
    private final CreditCardValidator validator = new CreditCardValidator();

    @Test
    void testValidVisaCards() {
        assertTrue(validator.isValidCreditCard("4111111111111111"), "Valid Visa card.");
        assertTrue(validator.isValidCreditCard("4000123456789012"), "Valid Visa card.");
    }

    @Test
    void testValidMasterCardCards() {
        assertTrue(validator.isValidCreditCard("5111111111111111"), "Valid MasterCard.");
        assertTrue(validator.isValidCreditCard("5200123456789012"), "Valid MasterCard.");
    }

    @Test
    void testInvalidCreditCards() {
        assertFalse(validator.isValidCreditCard("6111111111111111"), "Invalid prefix.");
        assertFalse(validator.isValidCreditCard("411111111111111"), "Too short.");
        assertFalse(validator.isValidCreditCard("51111111111111111"), "Too long.");
        assertFalse(validator.isValidCreditCard("1234567890123456"), "Invalid prefix.");
        assertFalse(validator.isValidCreditCard("4111-1111-1111-1111"), "Contains dashes.");
        assertFalse(validator.isValidCreditCard("4111 1111 1111 1111"), "Contains spaces.");
        assertFalse(validator.isValidCreditCard("abcd567890123456"), "Contains letters.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertFalse(validator.isValidCreditCard(null), "Null input should be invalid.");
        assertFalse(validator.isValidCreditCard(""), "Empty input should be invalid.");
    }
}

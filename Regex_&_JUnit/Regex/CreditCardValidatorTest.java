import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class CreditCardValidator {
    private static final String VISA_REGEX = "^4[0-9]{15}$"; // Starts with 4, 16 digits
    private static final String MASTERCARD_REGEX = "^5[1-5][0-9]{14}$"; // Starts with 51-55, 16 digits

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
        assertTrue(validator.isValidCreditCard("4111111111111111"));
        assertTrue(validator.isValidCreditCard("4000123412341234"));
    }

    @Test
    void testValidMasterCards() {
        assertTrue(validator.isValidCreditCard("5111111111111111"));
        assertTrue(validator.isValidCreditCard("5212345678901234"));
    }

    @Test
    void testInvalidCards() {
        assertFalse(validator.isValidCreditCard("6111111111111111")); // Invalid prefix
        assertFalse(validator.isValidCreditCard("411111111111111")); // Too short
        assertFalse(validator.isValidCreditCard("51111111111111111")); // Too long
        assertFalse(validator.isValidCreditCard("abcd111111111111")); // Contains letters
        assertFalse(validator.isValidCreditCard("4999999999999999")); // Incorrect Visa prefix
    }

    @Test
    void testNullAndEmpty() {
        assertFalse(validator.isValidCreditCard(null), "Null input should return false");
        assertFalse(validator.isValidCreditCard(""), "Empty string should return false");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CreditCardValidator {
    private static final String VISA_REGEX = "^4\\d{15}$";
    private static final String MASTERCARD_REGEX = "^5\\d{15}$";

    public boolean isValidCreditCard(String cardNumber) {
        return cardNumber != null && (cardNumber.matches(VISA_REGEX) || cardNumber.matches(MASTERCARD_REGEX));
    }
}

class CreditCardValidatorTest {
    private final CreditCardValidator validator = new CreditCardValidator();

    @Test
    void testValidVisaCards() {
        assertTrue(validator.isValidCreditCard("4111111111111111"), "Valid Visa card");
        assertTrue(validator.isValidCreditCard("4000123412341234"), "Valid Visa card");
    }

    @Test
    void testValidMasterCard() {
        assertTrue(validator.isValidCreditCard("5111111111111111"), "Valid MasterCard");
        assertTrue(validator.isValidCreditCard("5200123412341234"), "Valid MasterCard");
    }

    @Test
    void testInvalidCreditCards() {
        assertFalse(validator.isValidCreditCard("6111111111111111"), "Should start with 4 or 5");
        assertFalse(validator.isValidCreditCard("41111111111111"), "Too short");
        assertFalse(validator.isValidCreditCard("51111111111111111"), "Too long");
        assertFalse(validator.isValidCreditCard("abcd123456789012"), "Non-numeric characters");
        assertFalse(validator.isValidCreditCard("4 1111 1111 1111 111"), "Contains spaces");
        assertFalse(validator.isValidCreditCard(""), "Empty string");
        assertFalse(validator.isValidCreditCard(null), "Null should be invalid");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtils {
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

class StringUtilsTest {
    private final StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", utils.reverse("abc"));
        assertEquals("54321", utils.reverse("12345"));
        assertNull(utils.reverse(null));
        assertEquals("", utils.reverse(""));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("Racecar"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
        assertTrue(utils.isPalindrome("")); // Empty string is considered a palindrome
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("WORLD", utils.toUpperCase("world"));
        assertNull(utils.toUpperCase(null));
        assertEquals("", utils.toUpperCase(""));
    }
}

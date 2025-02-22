import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpaceNormalizer {
    public String normalizeSpaces(String text) {
        if (text == null) return null;
        return text.replaceAll("\\s+", " ").trim();
    }
}

class SpaceNormalizerTest {
    private final SpaceNormalizer normalizer = new SpaceNormalizer();

    @Test
    void testMultipleSpaces() {
        String input = "This   is  an   example    with   multiple   spaces.";
        String expected = "This is an example with multiple spaces.";
        assertEquals(expected, normalizer.normalizeSpaces(input));
    }

    @Test
    void testLeadingAndTrailingSpaces() {
        String input = "   Leading and trailing spaces   ";
        String expected = "Leading and trailing spaces";
        assertEquals(expected, normalizer.normalizeSpaces(input));
    }

    @Test
    void testSingleSpaces() {
        String input = "No extra spaces here.";
        assertEquals(input, normalizer.normalizeSpaces(input));
    }

    @Test
    void testEmptyOrNullInput() {
        assertEquals("", normalizer.normalizeSpaces(""), "Should return an empty string for empty input");
        assertNull(normalizer.normalizeSpaces(null), "Should return null for null input");
    }
}

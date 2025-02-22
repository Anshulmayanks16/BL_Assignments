import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpaceNormalizer {
    public String normalizeSpaces(String text) {
        if (text == null) return "";
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
        String input = "   Hello   World   ";
        String expected = "Hello World";
        assertEquals(expected, normalizer.normalizeSpaces(input));
    }

    @Test
    void testSingleSpaces() {
        String input = "This is fine.";
        String expected = "This is fine.";
        assertEquals(expected, normalizer.normalizeSpaces(input));
    }

    @Test
    void testEmptyAndNullInput() {
        assertEquals("", normalizer.normalizeSpaces(null), "Null input should return an empty string.");
        assertEquals("", normalizer.normalizeSpaces("   "), "Only spaces should return an empty string.");
    }

    @Test
    void testTabsAndNewlines() {
        String input = "Line1\t\tLine2\n\nLine3";
        String expected = "Line1 Line2 Line3";
        assertEquals(expected, normalizer.normalizeSpaces(input));
    }
}

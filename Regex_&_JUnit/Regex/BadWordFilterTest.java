import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.regex.Pattern;

class BadWordFilter {
    private static final Set<String> BAD_WORDS = Set.of("damn", "stupid");

    public String censorText(String text) {
        if (text == null) return "";

        String regex = "\\b(" + String.join("|", BAD_WORDS) + ")\\b";
        return text.replaceAll("(?i)" + regex, "****");
    }
}

class BadWordFilterTest {
    private final BadWordFilter filter = new BadWordFilter();

    @Test
    void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String expected = "This is a **** bad example with some **** words.";
        assertEquals(expected, filter.censorText(input));
    }

    @Test
    void testNoBadWords() {
        String input = "This is a clean sentence.";
        assertEquals(input, filter.censorText(input));
    }

    @Test
    void testMixedCaseBadWords() {
        String input = "This is a Damn stupid example.";
        String expected = "This is a **** **** example.";
        assertEquals(expected, filter.censorText(input));
    }

    @Test
    void testBadWordsWithPunctuation() {
        String input = "What a stupid, damn idea!";
        String expected = "What a ****, **** idea!";
        assertEquals(expected, filter.censorText(input));
    }

    @Test
    void testNullAndEmptyInput() {
        assertEquals("", filter.censorText(null), "Null input should return an empty string.");
        assertEquals("", filter.censorText(""), "Empty input should return an empty string.");
    }
}

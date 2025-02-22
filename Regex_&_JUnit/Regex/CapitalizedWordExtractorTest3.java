import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

class CapitalizedWordExtractor {
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]*\\b";
    private static final Pattern CAPITALIZED_PATTERN = Pattern.compile(CAPITALIZED_WORD_REGEX);

    public List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        if (text == null || text.isEmpty()) return capitalizedWords;

        Matcher matcher = CAPITALIZED_PATTERN.matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }
}

class CapitalizedWordExtractorTest {
    private final CapitalizedWordExtractor extractor = new CapitalizedWordExtractor();

    @Test
    void testExtractCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, extractor.extractCapitalizedWords(text), "Extracted words should match expected output.");
    }

    @Test
    void testNoCapitalizedWords() {
        String text = "this sentence has no capitalized words.";
        assertTrue(extractor.extractCapitalizedWords(text).isEmpty(), "No capitalized words should return an empty list.");
    }

    @Test
    void testMixedCaseWords() {
        String text = "NASA launched a Rocket named Falcon.";
        List<String> expected = List.of("NASA", "Rocket", "Falcon");
        assertEquals(expected, extractor.extractCapitalizedWords(text), "Should extract correctly capitalized words.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractCapitalizedWords(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractCapitalizedWords("").isEmpty(), "Empty input should return an empty list.");
    }
}

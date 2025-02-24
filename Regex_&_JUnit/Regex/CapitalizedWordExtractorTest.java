import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class CapitalizedWordExtractor {
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]*\\b";

    public List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        if (text == null || text.isEmpty()) return capitalizedWords;

        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }
}

class CapitalizedWordExtractorTest {
    private final CapitalizedWordExtractor extractor = new CapitalizedWordExtractor();

    @Test
    void testValidCapitalizedWordExtraction() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, extractor.extractCapitalizedWords(text));
    }

    @Test
    void testNoCapitalizedWords() {
        String text = "this is a sentence without any capitalized words.";
        assertTrue(extractor.extractCapitalizedWords(text).isEmpty(), "Should return an empty list");
    }

    @Test
    void testMixedCaseWords() {
        String text = "NASA launched Apollo 11 to the Moon.";
        List<String> expected = List.of("NASA", "Apollo", "Moon");
        assertEquals(expected, extractor.extractCapitalizedWords(text));
    }

    @Test
    void testEmptyOrNullInput() {
        assertTrue(extractor.extractCapitalizedWords("").isEmpty(), "Should return an empty list for empty input");
        assertTrue(extractor.extractCapitalizedWords(null).isEmpty(), "Should return an empty list for null input");
    
    }
}

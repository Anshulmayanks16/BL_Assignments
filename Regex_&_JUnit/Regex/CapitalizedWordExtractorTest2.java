import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class CapitalizedWordExtractor {
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]*\\b";

    public List<String> extractCapitalizedWords(String text) {
        if (text == null) return Collections.emptyList();

        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }
}

class CapitalizedWordExtractorTest {
    private final CapitalizedWordExtractor extractor = new CapitalizedWordExtractor();

    @Test
    void testExtractCapitalizedWords() {
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, extractor.extractCapitalizedWords(input));
    }

    @Test
    void testNoCapitalizedWords() {
        String input = "this sentence has no capitalized words.";
        assertTrue(extractor.extractCapitalizedWords(input).isEmpty(), "Should return an empty list when no capitalized words are found.");
    }

    @Test
    void testSingleCapitalizedWord() {
        String input = "Hello world.";
        List<String> expected = List.of("Hello");
        assertEquals(expected, extractor.extractCapitalizedWords(input));
    }

    @Test
    void testMultipleCapitalizedWords() {
        String input = "Alice went to Wonderland where she met the Mad Hatter.";
        List<String> expected = List.of("Alice", "Wonderland", "Mad", "Hatter");
        assertEquals(expected, extractor.extractCapitalizedWords(input));
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractCapitalizedWords(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractCapitalizedWords("").isEmpty(), "Empty input should return an empty list.");
    }
}

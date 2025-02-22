import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class RepeatingWordFinder {
    private static final String WORD_REGEX = "\\b(\\w+)\\b";

    public Set<String> findRepeatingWords(String text) {
        if (text == null) return Collections.emptySet();

        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> wordCount = new HashMap<>();
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}

class RepeatingWordFinderTest {
    private final RepeatingWordFinder finder = new RepeatingWordFinder();

    @Test
    void testFindRepeatingWords() {
        String input = "This is is a repeated repeated word test.";
        Set<String> expected = Set.of("is", "repeated");
        assertEquals(expected, finder.findRepeatingWords(input));
    }

    @Test
    void testNoRepeatingWords() {
        String input = "Each word is unique.";
        assertTrue(finder.findRepeatingWords(input).isEmpty(), "Should return an empty set when no words are repeated.");
    }

    @Test
    void testCaseInsensitivity() {
        String input = "Hello hello world World";
        Set<String> expected = Set.of("hello", "world");
        assertEquals(expected, finder.findRepeatingWords(input), "Should match words case-insensitively.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(finder.findRepeatingWords(null).isEmpty(), "Null input should return an empty set.");
        assertTrue(finder.findRepeatingWords("").isEmpty(), "Empty input should return an empty set.");
    }
}

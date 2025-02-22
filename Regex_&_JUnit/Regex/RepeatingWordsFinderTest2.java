import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class RepeatingWordsFinder {
    private static final String REPEATING_WORDS_REGEX = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";
    private static final Pattern REPEATING_PATTERN = Pattern.compile(REPEATING_WORDS_REGEX, Pattern.CASE_INSENSITIVE);

    public Set<String> findRepeatingWords(String text) {
        if (text == null) return Collections.emptySet();
        Matcher matcher = REPEATING_PATTERN.matcher(text);
        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }
        return repeatingWords;
    }
}

class RepeatingWordsFinderTest {
    private final RepeatingWordsFinder finder = new RepeatingWordsFinder();

    @Test
    void testValidRepeatingWords() {
        assertEquals(Set.of("is", "repeated"),
                     finder.findRepeatingWords("This is is a repeated repeated word test."));
        assertEquals(Set.of("word"),
                     finder.findRepeatingWords("Word word word test."));
    }

    @Test
    void testNoRepeatingWords() {
        assertTrue(finder.findRepeatingWords("This sentence has unique words.").isEmpty());
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(finder.findRepeatingWords(null).isEmpty(), "Null input should return an empty set.");
        assertTrue(finder.findRepeatingWords("").isEmpty(), "Empty input should return an empty set.");
    }
}

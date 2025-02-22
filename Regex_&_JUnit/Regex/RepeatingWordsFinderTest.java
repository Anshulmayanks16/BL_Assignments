import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class RepeatingWordsFinder {
    public Set<String> findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)");
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatingWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }
        return repeatingWords;
    }
}

class RepeatingWordsFinderTest {
    private final RepeatingWordsFinder finder = new RepeatingWordsFinder();

    @Test
    void testFindRepeatingWords() {
        String text = "This is is a repeated repeated word test.";
        Set<String> expected = new LinkedHashSet<>(Arrays.asList("is", "repeated"));
        assertEquals(expected, finder.findRepeatingWords(text));
    }

    @Test
    void testNoRepeatingWords() {
        String text = "Every word here is unique.";
        assertTrue(finder.findRepeatingWords(text).isEmpty());
    }

    @Test
    void testMultipleOccurrences() {
        String text = "apple banana apple banana orange apple";
        Set<String> expected = new LinkedHashSet<>(Arrays.asList("apple", "banana"));
        assertEquals(expected, finder.findRepeatingWords(text));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

class BadWordCensor {
    private final Set<String> badWords = new HashSet<>(Set.of("damn", "stupid"));

    public String censorBadWords(String text) {
        if (text == null) return null;
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";
        return text.replaceAll(regex, "****");
    }
}

class BadWordCensorTest {
    private final BadWordCensor censor = new BadWordCensor();

    @Test
    void testCensorBadWords() {
        assertEquals("This is a **** bad example with some **** words.",
                     censor.censorBadWords("This is a damn bad example with some stupid words."),
                     "Bad words should be replaced with ****.");
    }

    @Test
    void testNoBadWords() {
        assertEquals("This is a clean sentence.",
                     censor.censorBadWords("This is a clean sentence."),
                     "If no bad words are found, the text should remain unchanged.");
    }

    @Test
    void testPartialWordsNotCensored() {
        assertEquals("This is a damnation story.",
                     censor.censorBadWords("This is a damnation story."),
                     "Partial matches (like damnation) should not be censored.");
    }

    @Test
    void testCaseInsensitiveCensoring() {
        assertEquals("This is **** and ****.",
                     censor.censorBadWords("This is dAmN and StUpId."),
                     "Bad words should be censored regardless of case.");
    }

    @Test
    void testNullInput() {
        assertNull(censor.censorBadWords(null),
                   "Null input should return null.");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class BadWordCensor {
    private final List<String> badWords = List.of("damn", "stupid");

    public String censorText(String text) {
        if (text == null) return null;

        String censoredText = text;
        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            censoredText = censoredText.replaceAll(regex, "****");
        }
        return censoredText;
    }
}

class BadWordCensorTest {
    private final BadWordCensor censor = new BadWordCensor();

    @Test
    void testCensoringBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String expected = "This is a **** bad example with some **** words.";
        assertEquals(expected, censor.censorText(input));
    }

    @Test
    void testNoBadWords() {
        String input = "This is a clean sentence.";
        assertEquals(input, censor.censorText(input), "Text should remain unchanged if no bad words are present");
    }

    @Test
    void testPartialWordNotCensored() {
        String input = "This is a damning statement.";
        assertEquals(input, censor.censorText(input), "Partial words should not be censored");
    }

    @Test
    void testEmptyOrNullInput() {
        assertEquals("", censor.censorText(""), "Should return an empty string for empty input");
        assertNull(censor.censorText(null), "Should return null for null input");
    }
}

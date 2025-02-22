import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

class EmailExtractor {
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        if (text == null || text.isEmpty()) return emails;
        
        Matcher matcher = EMAIL_PATTERN.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}

class EmailExtractorTest {
    private final EmailExtractor extractor = new EmailExtractor();

    @Test
    void testExtractEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> expected = List.of("support@example.com", "info@company.org");
        assertEquals(expected, extractor.extractEmails(text), "Emails should be correctly extracted.");
    }

    @Test
    void testNoEmailsInText() {
        String text = "This text has no emails.";
        assertTrue(extractor.extractEmails(text).isEmpty(), "No emails should return an empty list.");
    }

    @Test
    void testMixedTextWithEmails() {
        String text = "Send an email to john.doe123@mail.net or visit www.example.com for more info.";
        List<String> expected = List.of("john.doe123@mail.net");
        assertEquals(expected, extractor.extractEmails(text), "Extracted email should match.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractEmails(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractEmails("").isEmpty(), "Empty input should return an empty list.");
    }
}

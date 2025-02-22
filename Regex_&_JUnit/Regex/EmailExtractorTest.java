import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class EmailExtractor {
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        if (text == null || text.isEmpty()) return emails;

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}

class EmailExtractorTest {
    private final EmailExtractor extractor = new EmailExtractor();

    @Test
    void testValidEmailExtraction() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> expected = List.of("support@example.com", "info@company.org");
        assertEquals(expected, extractor.extractEmails(text));
    }

    @Test
    void testNoEmailsInText() {
        String text = "No emails here, just text.";
        assertTrue(extractor.extractEmails(text).isEmpty(), "Should return an empty list");
    }

    @Test
    void testMixedContentWithEmails() {
        String text = "Hello john.doe123@example.com! Reach me at admin@website.net.";
        List<String> expected = List.of("john.doe123@example.com", "admin@website.net");
        assertEquals(expected, extractor.extractEmails(text));
    }

    @Test
    void testEmailsWithSpecialCharacters() {
        String text = "Valid emails: first.last+alias@domain.com, user_name@sub.domain.org.";
        List<String> expected = List.of("first.last+alias@domain.com", "user_name@sub.domain.org");
        assertEquals(expected, extractor.extractEmails(text));
    }

    @Test
    void testEmptyOrNullInput() {
        assertTrue(extractor.extractEmails("").isEmpty(), "Should return an empty list for empty input");
        assertTrue(extractor.extractEmails(null).isEmpty(), "Should return an empty list for null input");
    }
}

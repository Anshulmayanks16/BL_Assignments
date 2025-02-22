import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class EmailExtractor {
    private static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";

    public List<String> extractEmails(String text) {
        if (text == null) return Collections.emptyList();

        List<String> emails = new ArrayList<>();
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
    void testExtractEmails() {
        String input = "Contact us at support@example.com and info@company.org";
        List<String> expected = List.of("support@example.com", "info@company.org");
        assertEquals(expected, extractor.extractEmails(input));
    }

    @Test
    void testNoEmails() {
        String input = "This text has no email addresses.";
        assertTrue(extractor.extractEmails(input).isEmpty(), "Should return an empty list when no emails are found.");
    }

    @Test
    void testMultipleEmails() {
        String input = "Emails: user1@mail.com, admin@site.net, test@domain.com";
        List<String> expected = List.of("user1@mail.com", "admin@site.net", "test@domain.com");
        assertEquals(expected, extractor.extractEmails(input));
    }

    @Test
    void testInvalidEmails() {
        String input = "Invalid: user@@example, test@.com, @missing.com";
        assertTrue(extractor.extractEmails(input).isEmpty(), "Should ignore invalid email addresses.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractEmails(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractEmails("").isEmpty(), "Empty input should return an empty list.");
    }
}

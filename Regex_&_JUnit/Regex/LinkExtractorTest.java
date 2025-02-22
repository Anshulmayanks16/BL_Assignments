import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class LinkExtractor {
    private static final String URL_REGEX = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/[a-zA-Z0-9._%+-]*)*\\b";

    public List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null || text.isEmpty()) return links;

        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}

class LinkExtractorTest {
    private final LinkExtractor extractor = new LinkExtractor();

    @Test
    void testValidLinkExtraction() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = List.of("https://www.google.com", "http://example.org");
        assertEquals(expected, extractor.extractLinks(text));
    }

    @Test
    void testNoLinksInText() {
        String text = "This sentence has no links.";
        assertTrue(extractor.extractLinks(text).isEmpty(), "Should return an empty list");
    }

    @Test
    void testMixedContentWithLinks() {
        String text = "Check out https://github.com/user/repo and http://www.example.com/page.html";
        List<String> expected = List.of("https://github.com/user/repo", "http://www.example.com/page.html");
        assertEquals(expected, extractor.extractLinks(text));
    }

    @Test
    void testInvalidLinks() {
        String text = "These are invalid: www.google.com, google.com/page, ftp://example.com";
        assertTrue(extractor.extractLinks(text).isEmpty(), "Should not match invalid URLs");
    }

    @Test
    void testEmptyOrNullInput() {
        assertTrue(extractor.extractLinks("").isEmpty(), "Should return an empty list for empty input");
        assertTrue(extractor.extractLinks(null).isEmpty(), "Should return an empty list for null input");
    }
}

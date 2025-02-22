import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;

class LinkExtractor {
    private static final String URL_REGEX = "\\bhttps?://[\\w.-]+(?:\\.[a-z]{2,})+(?:/[\\w.-]*)*\\b";

    public List<String> extractLinks(String text) {
        if (text == null) return Collections.emptyList();

        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);
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
    void testExtractValidLinks() {
        String input = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = List.of("https://www.google.com", "http://example.org");
        assertEquals(expected, extractor.extractLinks(input));
    }

    @Test
    void testNoLinks() {
        String input = "This text has no URLs.";
        assertTrue(extractor.extractLinks(input).isEmpty(), "Should return an empty list when no links are found.");
    }

    @Test
    void testSingleLink() {
        String input = "Check out https://openai.com for AI research.";
        List<String> expected = List.of("https://openai.com");
        assertEquals(expected, extractor.extractLinks(input));
    }

    @Test
    void testMixedTextWithLinks() {
        String input = "Resources: https://docs.oracle.com, http://mywebsite.net/blog, and www.invalid.com";
        List<String> expected = List.of("https://docs.oracle.com", "http://mywebsite.net/blog");
        assertEquals(expected, extractor.extractLinks(input));
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractLinks(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractLinks("").isEmpty(), "Empty input should return an empty list.");
    }
}

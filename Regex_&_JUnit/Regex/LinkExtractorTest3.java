import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

class LinkExtractor {
    private static final String URL_REGEX = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[\\w\\-._~:/?#[\\]@!$&'()*+,;=]*)?\\b";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null || text.isEmpty()) return links;

        Matcher matcher = URL_PATTERN.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}

class LinkExtractorTest {
    private final LinkExtractor extractor = new LinkExtractor();

    @Test
    void testExtractLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = List.of("https://www.google.com", "http://example.org");
        assertEquals(expected, extractor.extractLinks(text), "Extracted links should match expected output.");
    }

    @Test
    void testNoLinks() {
        String text = "There are no links in this text.";
        assertTrue(extractor.extractLinks(text).isEmpty(), "No links should return an empty list.");
    }

    @Test
    void testInvalidLinks() {
        String text = "Invalid URLs: htp://wrong.com, www.missinghttp.com, http:/incomplete.com.";
        assertTrue(extractor.extractLinks(text).isEmpty(), "Invalid links should not be extracted.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractLinks(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractLinks("").isEmpty(), "Empty input should return an empty list.");
    }
}

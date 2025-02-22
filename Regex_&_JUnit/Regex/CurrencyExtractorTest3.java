import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class CurrencyExtractor {
    public List<String> extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        List<String> results = new ArrayList<>();
        
        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }
}

class CurrencyExtractorTest {
    private final CurrencyExtractor extractor = new CurrencyExtractor();

    @Test
    void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = Arrays.asList("$45.99", "10.50");
        assertEquals(expected, extractor.extractCurrencyValues(text));
    }

    @Test
    void testNoCurrencyValues() {
        String text = "There are no prices mentioned here.";
        assertTrue(extractor.extractCurrencyValues(text).isEmpty());
    }

    @Test
    void testMultipleCurrencyValues() {
        String text = "Total: $99.99, Tax: $5.00, Final: 104.99.";
        List<String> expected = Arrays.asList("$99.99", "$5.00", "104.99");
        assertEquals(expected, extractor.extractCurrencyValues(text));
    }
}

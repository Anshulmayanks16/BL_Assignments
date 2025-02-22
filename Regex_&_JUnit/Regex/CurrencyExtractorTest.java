import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class CurrencyExtractor {
    private static final String CURRENCY_REGEX = "\\$?\\b\\d+\\.\\d{2}\\b";

    public List<String> extractCurrencyValues(String text) {
        if (text == null) return Collections.emptyList();

        List<String> extractedValues = new ArrayList<>();
        Pattern pattern = Pattern.compile(CURRENCY_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }

        return extractedValues;
    }
}

class CurrencyExtractorTest {
    private final CurrencyExtractor extractor = new CurrencyExtractor();

    @Test
    void testExtractCurrencyValues() {
        String input = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = List.of("$45.99", "10.50");
        assertEquals(expected, extractor.extractCurrencyValues(input));
    }

    @Test
    void testNoCurrencyValues() {
        String input = "This text has no currency values.";
        assertTrue(extractor.extractCurrencyValues(input).isEmpty(), "Should return an empty list when no currency values are found.");
    }

    @Test
    void testMultipleCurrencies() {
        String input = "Items cost $5.00, 7.99, and $12.45.";
        List<String> expected = List.of("$5.00", "7.99", "$12.45");
        assertEquals(expected, extractor.extractCurrencyValues(input));
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractCurrencyValues(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractCurrencyValues("").isEmpty(), "Empty input should return an empty list.");
    }
}

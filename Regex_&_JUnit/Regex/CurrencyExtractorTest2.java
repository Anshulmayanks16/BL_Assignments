import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class CurrencyExtractor {
    private static final String CURRENCY_REGEX = "\\$?\\d+(\\.\\d{2})?";
    private static final Pattern CURRENCY_PATTERN = Pattern.compile(CURRENCY_REGEX);

    public List<String> extractCurrencyValues(String text) {
        if (text == null) return Collections.emptyList();
        Matcher matcher = CURRENCY_PATTERN.matcher(text);
        List<String> values = new ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
}

class CurrencyExtractorTest {
    private final CurrencyExtractor extractor = new CurrencyExtractor();

    @Test
    void testValidExtraction() {
        assertEquals(List.of("$45.99", "10.50"),
                     extractor.extractCurrencyValues("The price is $45.99, and the discount is 10.50."));
        assertEquals(List.of("$100", "$9.99", "5.00"),
                     extractor.extractCurrencyValues("I spent $100 on a new phone, $9.99 on a case, and 5.00 on shipping."));
    }

    @Test
    void testNoCurrencyFound() {
        assertTrue(extractor.extractCurrencyValues("There are no prices mentioned.").isEmpty());
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractCurrencyValues(null).isEmpty(), "Null input should return empty list.");
        assertTrue(extractor.extractCurrencyValues("").isEmpty(), "Empty input should return empty list.");
    }
}

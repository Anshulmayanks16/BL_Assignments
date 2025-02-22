import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

class DateExtractor {
    private static final String DATE_REGEX = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

    public List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        if (text == null || text.isEmpty()) return dates;

        Matcher matcher = DATE_PATTERN.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}

class DateExtractorTest {
    private final DateExtractor extractor = new DateExtractor();

    @Test
    void testExtractDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, extractor.extractDates(text), "Extracted dates should match expected output.");
    }

    @Test
    void testNoDates() {
        String text = "There are no dates in this text.";
        assertTrue(extractor.extractDates(text).isEmpty(), "No dates should return an empty list.");
    }

    @Test
    void testInvalidDates() {
        String text = "Invalid dates: 32/01/2022, 00/12/2023, 15-08-2024.";
        assertTrue(extractor.extractDates(text).isEmpty(), "Invalid dates should not be extracted.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractDates(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractDates("").isEmpty(), "Empty input should return an empty list.");
    }
}

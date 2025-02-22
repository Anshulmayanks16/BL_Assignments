import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;

class DateExtractor {
    private static final String DATE_REGEX = "\\b(\\d{2}/\\d{2}/\\d{4})\\b";

    public List<String> extractDates(String text) {
        if (text == null) return Collections.emptyList();

        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }
}

class DateExtractorTest {
    private final DateExtractor extractor = new DateExtractor();

    @Test
    void testExtractValidDates() {
        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, extractor.extractDates(input));
    }

    @Test
    void testNoDates() {
        String input = "There are no dates in this text.";
        assertTrue(extractor.extractDates(input).isEmpty(), "Should return an empty list when no dates are found.");
    }

    @Test
    void testSingleDate() {
        String input = "My birthday is on 25/12/1995.";
        List<String> expected = List.of("25/12/1995");
        assertEquals(expected, extractor.extractDates(input));
    }

    @Test
    void testMixedFormats() {
        String input = "Dates: 01/01/2020, 2020-12-31, and 10-05-2021.";
        List<String> expected = List.of("01/01/2020");
        assertEquals(expected, extractor.extractDates(input));
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractDates(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractDates("").isEmpty(), "Empty input should return an empty list.");
    }
}

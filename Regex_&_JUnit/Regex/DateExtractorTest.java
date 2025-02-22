import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class DateExtractor {
    private static final String DATE_REGEX = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

    public List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        if (text == null || text.isEmpty()) return dates;

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
    void testValidDateExtraction() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, extractor.extractDates(text));
    }

    @Test
    void testNoDatesInText() {
        String text = "There are no dates in this sentence.";
        assertTrue(extractor.extractDates(text).isEmpty(), "Should return an empty list");
    }

    @Test
    void testMixedContentWithDates() {
        String text = "Important dates: 01/01/2000, 31/12/1999. Some random text here.";
        List<String> expected = List.of("01/01/2000", "31/12/1999");
        assertEquals(expected, extractor.extractDates(text));
    }

    @Test
    void testInvalidDates() {
        String text = "These are incorrect: 32/01/2022, 29/02/2021, 00/12/2020.";
        assertTrue(extractor.extractDates(text).isEmpty(), "Should not match invalid dates");
    }

    @Test
    void testEmptyOrNullInput() {
        assertTrue(extractor.extractDates("").isEmpty(), "Should return an empty list for empty input");
        assertTrue(extractor.extractDates(null).isEmpty(), "Should return an empty list for null input");
    }
}

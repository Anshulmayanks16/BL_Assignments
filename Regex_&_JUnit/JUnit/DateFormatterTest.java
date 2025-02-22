import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class DateFormatter {
    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd");
        }
    }
}

class DateFormatterTest {
    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDateConversion() {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
        assertEquals("01-01-2022", formatter.formatDate("2022-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("12-25-2023"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testEmptyOrNullDate() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(""));
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(null));
    }
}

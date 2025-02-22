import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpaceReducer {
    public String replaceMultipleSpaces(String text) {
        if (text == null) return null;
        return text.replaceAll("\\s+", " ").trim();
    }
}

class SpaceReducerTest {
    private final SpaceReducer reducer = new SpaceReducer();

    @Test
    void testReplaceMultipleSpaces() {
        assertEquals("This is an example with multiple spaces.", 
                     reducer.replaceMultipleSpaces("This   is  an    example with  multiple   spaces."),
                     "Multiple spaces should be replaced with a single space.");
    }

    @Test
    void testLeadingAndTrailingSpaces() {
        assertEquals("Trimmed text", reducer.replaceMultipleSpaces("   Trimmed   text   "),
                     "Leading and trailing spaces should be removed.");
    }

    @Test
    void testSingleWord() {
        assertEquals("Hello", reducer.replaceMultipleSpaces("   Hello   "),
                     "Single word with spaces should be trimmed.");
    }

    @Test
    void testEmptyString() {
        assertEquals("", reducer.replaceMultipleSpaces("   "),
                     "Only spaces should result in an empty string.");
    }

    @Test
    void testNullInput() {
        assertNull(reducer.replaceMultipleSpaces(null),
                   "Null input should return null.");
    }
}

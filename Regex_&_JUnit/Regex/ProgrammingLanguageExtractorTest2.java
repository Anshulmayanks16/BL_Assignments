import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class ProgrammingLanguageExtractor {
    private static final String LANGUAGE_REGEX = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|TypeScript|Perl|Scala)\\b";
    private static final Pattern LANGUAGE_PATTERN = Pattern.compile(LANGUAGE_REGEX);

    public List<String> extractLanguages(String text) {
        if (text == null) return Collections.emptyList();
        Matcher matcher = LANGUAGE_PATTERN.matcher(text);
        List<String> languages = new ArrayList<>();
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }
}

class ProgrammingLanguageExtractorTest {
    private final ProgrammingLanguageExtractor extractor = new ProgrammingLanguageExtractor();

    @Test
    void testValidExtraction() {
        assertEquals(List.of("Java", "Python", "JavaScript", "Go"),
                     extractor.extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        assertEquals(List.of("C++", "Rust"),
                     extractor.extractLanguages("C++ and Rust are great for system programming."));
    }

    @Test
    void testNoLanguagesFound() {
        assertTrue(extractor.extractLanguages("This sentence has no programming languages.").isEmpty());
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractLanguages(null).isEmpty(), "Null input should return empty list.");
        assertTrue(extractor.extractLanguages("").isEmpty(), "Empty input should return empty list.");
    }
}

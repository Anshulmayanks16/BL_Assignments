import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class ProgrammingLanguageExtractor {
    private static final List<String> LANGUAGES = Arrays.asList(
            "Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "PHP", "Rust", "Perl"
    );

    public List<String> extractLanguages(String text) {
        return LANGUAGES.stream()
                .filter(text::contains)
                .collect(Collectors.toList());
    }
}

class ProgrammingLanguageExtractorTest {
    private final ProgrammingLanguageExtractor extractor = new ProgrammingLanguageExtractor();

    @Test
    void testExtractLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = Arrays.asList("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, extractor.extractLanguages(text));
    }

    @Test
    void testNoLanguagesFound() {
        String text = "This sentence has no programming languages.";
        assertTrue(extractor.extractLanguages(text).isEmpty());
    }

    @Test
    void testPartialWordsNotMatched() {
        String text = "I enjoy cooking in JavaBeans and playing GoKart.";
        List<String> expected = Arrays.asList("Go");  // "JavaBeans" should not match "Java"
        assertEquals(expected, extractor.extractLanguages(text));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class ProgrammingLanguageExtractor {
    private static final List<String> LANGUAGES = List.of("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "PHP", "R", "TypeScript");

    public List<String> extractLanguages(String text) {
        if (text == null) return Collections.emptyList();

        List<String> foundLanguages = new ArrayList<>();
        for (String language : LANGUAGES) {
            String regex = "\\b" + Pattern.quote(language) + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(language);
            }
        }
        return foundLanguages;
    }
}

class ProgrammingLanguageExtractorTest {
    private final ProgrammingLanguageExtractor extractor = new ProgrammingLanguageExtractor();

    @Test
    void testExtractLanguages() {
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = List.of("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, extractor.extractLanguages(input));
    }

    @Test
    void testNoLanguages() {
        String input = "This text has no programming languages.";
        assertTrue(extractor.extractLanguages(input).isEmpty(), "Should return an empty list when no languages are found.");
    }

    @Test
    void testCaseSensitivity() {
        String input = "I enjoy java, PYTHON, and jAvAsCrIpT.";
        List<String> expected = List.of("Java", "Python", "JavaScript");
        assertEquals(expected, extractor.extractLanguages(input), "Should match case-insensitively.");
    }

    @Test
    void testNullAndEmptyInput() {
        assertTrue(extractor.extractLanguages(null).isEmpty(), "Null input should return an empty list.");
        assertTrue(extractor.extractLanguages("").isEmpty(), "Empty input should return an empty list.");
    }
}

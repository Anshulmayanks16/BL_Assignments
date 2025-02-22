import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";
    private final FileProcessor fileProcessor = new FileProcessor();

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);
        
        assertTrue(Files.exists(Paths.get(TEST_FILE)), "File should exist after writing");
        assertEquals(content, fileProcessor.readFromFile(TEST_FILE), "Content should match");
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}

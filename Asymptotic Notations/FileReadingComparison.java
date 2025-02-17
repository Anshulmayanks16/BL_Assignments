import java.io.*;

public class FileReadingComparison {
    
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with actual file path

        System.out.println("Reading File: " + filePath);

        // FileReader Test
        long startTime = System.nanoTime();
        readFileUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;
        System.out.println("FileReader Time: " + (fileReaderTime / 1e6) + " ms");

        // InputStreamReader Test
        startTime = System.nanoTime();
        readFileUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - startTime;
        System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1e6) + " ms");
    }

    // Reading file using FileReader (Character Stream)
    private static void readFileUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {} // Reading character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reading file using InputStreamReader (Byte Stream)
    private static void readFileUsingInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {} // Reading byte by byte
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
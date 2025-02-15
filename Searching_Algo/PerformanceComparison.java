import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";
        String filePath = "largeFile.txt"; // Change this to your large file path

        // Compare StringBuilder vs StringBuffer
        compareStringConcatenation(text, iterations);

        // Compare FileReader vs InputStreamReader
        compareFileReading(filePath);
    }

    private static void compareStringConcatenation(String text, int iterations) {
        // Measure StringBuilder performance
        long startTime1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime1 = System.nanoTime();
        long durationStringBuilder = endTime1 - startTime1;

        // Measure StringBuffer performance
        long startTime2 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTime2 = System.nanoTime();
        long durationStringBuffer = endTime2 - startTime2;

        // Print comparison results
        System.out.println("StringBuilder time: " + durationStringBuilder / 1_000_000 + " ms");
        System.out.println("StringBuffer time: " + durationStringBuffer / 1_000_000 + " ms");
    }

    private static void compareFileReading(String filePath) {
        // Measure FileReader performance
        long startTime1 = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long endTime1 = System.nanoTime();
        long durationFileReader = endTime1 - startTime1;

        // Measure InputStreamReader performance
        long startTime2 = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        long endTime2 = System.nanoTime();
        long durationInputStreamReader = endTime2 - startTime2;

        // Print comparison results
        System.out.println("Word count using FileReader: " + wordCountFileReader);
        System.out.println("FileReader time: " + durationFileReader / 1_000_000 + " ms");

        System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
        System.out.println("InputStreamReader time: " + durationInputStreamReader / 1_000_000 + " ms");
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file using FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}

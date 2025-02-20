import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filename = "sample.txt"; // Change to your actual file path
        Map<String, Integer> wordCount = countWordFrequency(filename);
        
        System.out.println("Word Frequencies: " + wordCount);
    }

    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Normalize: Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");

                // Split into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) { // Ensure it's not empty
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return wordCountMap;
    }
}

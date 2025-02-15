import java.io.*;

public class WordCounter {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        targetWord = targetWord.toLowerCase(); // Convert to lowercase for case-insensitive comparison

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
        return count;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file path
        String targetWord = "java"; // Word to count

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times in the file.");
    }
}
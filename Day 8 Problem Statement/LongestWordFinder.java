import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Find the longest word
        String longestWord = findLongestWord(sentence);

        // Output result
        System.out.println("The longest word is: " + longestWord);

        scanner.close();
    }

    // Method to find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split by spaces
        String longestWord = "";
        
        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
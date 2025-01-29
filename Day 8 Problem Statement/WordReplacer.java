import java.util.Scanner;

public class WordReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();

        // Input word to replace and the word to replace with
        System.out.print("Enter the word to replace: ");
        String wordToReplace = scanner.nextLine();

        System.out.print("Enter the word to replace with: ");
        String replacementWord = scanner.nextLine();

        // Replace the word
        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);

        // Output the modified sentence
        System.out.println("Modified Sentence: " + modifiedSentence);

        scanner.close();
    }

    // Method to replace a word with another in the sentence
    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        // Split the sentence into words and process
        String[] words = sentence.split("\\s+");
        StringBuilder modifiedSentence = new StringBuilder();

        // Iterate through the words
        for (String word : words) {
            if (word.equals(wordToReplace)) {
                modifiedSentence.append(replacementWord); // Replace word
            } else {
                modifiedSentence.append(word); // Keep original word
            }
            modifiedSentence.append(" "); // Add space between words
        }

        // Remove the last space and return the modified sentence
        return modifiedSentence.toString().trim();
    }
}

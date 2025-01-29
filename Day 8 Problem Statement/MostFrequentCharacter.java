import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find the most frequent character
        char mostFrequent = findMostFrequentCharacter(input);

        // Output result
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");

        scanner.close();
    }

    // Method to find the most frequent character
    public static char findMostFrequentCharacter(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        char mostFrequentChar = str.charAt(0);

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);

            // Update most frequent character
            if (frequencyMap.get(ch) > maxCount) {
                maxCount = frequencyMap.get(ch);
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }
}
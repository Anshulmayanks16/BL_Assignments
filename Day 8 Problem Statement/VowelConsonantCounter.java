import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Convert to lowercase to handle case insensitivity
        input = input.toLowerCase();
        
        int vowels = 0, consonants = 0;
        
        // Define vowel characters
        String vowelsList = "aeiou";

        // Loop through each character
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) { // Check if it's a letter
                if (vowelsList.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Output result
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        
        scanner.close();
    }
}
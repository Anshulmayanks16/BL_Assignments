import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {
        // If the lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Loop through each character of the first string
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            boolean charFound = false;
            
            // Try to find a matching character in the second string
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == char1) {
                    // If a match is found, remove that character by setting it to a non-matching character
                    str2 = str2.substring(0, j) + '?' + str2.substring(j + 1);
                    charFound = true;
                    break;
                }
            }

            // If the character wasn't found in the second string, they are not anagrams
            if (!charFound) {
                return false;
            }
        }

        return true;  // All characters matched
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two strings from the user
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Check if they are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }

        scanner.close();
    }
}

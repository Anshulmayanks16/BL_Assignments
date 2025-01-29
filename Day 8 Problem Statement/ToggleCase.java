import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Toggle case
        String toggledString = toggleCase(input);

        // Output result
        System.out.println("Toggled string: " + toggledString);

        scanner.close();
    }

    // Method to toggle case of each character
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch); // Keep non-alphabetic characters unchanged
            }
        }
        return result.toString();
    }
}
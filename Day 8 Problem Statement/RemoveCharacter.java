import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Input character to remove
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);

        // Remove the specific character
        String result = removeCharacter(input, charToRemove);

        // Output result
        System.out.println("String after removing character '" + charToRemove + "': " + result);

        scanner.close();
    }

    // Method to remove all occurrences of a specific character from a string
    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(String.valueOf(ch), "");
    }
}
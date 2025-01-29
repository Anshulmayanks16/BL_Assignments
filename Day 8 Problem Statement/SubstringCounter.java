import java.util.Scanner;

public class SubstringCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input main string
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        // Input substring to search
        System.out.print("Enter the substring to count: ");
        String subString = scanner.nextLine();

        // Count occurrences
        int count = countOccurrences(mainString, subString);

        // Output result
        System.out.println("The substring \"" + subString + "\" appears " + count + " times.");

        scanner.close();
    }

    // Method to count occurrences of a substring
    public static int countOccurrences(String mainString, String subString) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // Move index forward
        }

        return count;
    }
}
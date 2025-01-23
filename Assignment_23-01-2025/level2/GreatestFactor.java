import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get an integer input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
            return;
        }

        // Initialize greatestFactor variable
        int greatestFactor = 1;

        // Loop to find the greatest factor
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i; // Assign the factor
                break; // Exit the loop after finding the greatest factor
            }
        }

        // Display the greatest factor
        System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);

        scanner.close();
    }
}
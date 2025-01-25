import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take the input for a number
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            return;
        }

        // Initialize variables
        int maxFactor = 10; // Initial size of the factors array
        int[] factors = new int[maxFactor]; // Array to store factors
        int index = 0; // To track the current index of the factors array

        // Find factors of the number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Check if the factors array needs resizing
                if (index == maxFactor) {
                    maxFactor *= 2; // Double the size of maxFactor
                    int[] temp = new int[maxFactor]; // Temporary array

                    // Copy elements from factors to temp
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    // Assign temp back to factors
                    factors = temp;
                }

                // Add the factor to the array
                factors[index] = i;
                index++;
            }
        }

        // Display the factors of the number
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
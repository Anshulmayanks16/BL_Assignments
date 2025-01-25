import java.util.Scanner;

public class MultiplicationTable6to9 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a number to find its multiplication table from 6 to 9: ");
        int number = scanner.nextInt();

        // Define an integer array to store the multiplication results
        int[] multiplicationResult = new int[4]; // Array for results from 6 to 9

        // Calculate the multiplication results for numbers 6 to 9
        for (int i = 0; i < multiplicationResult.length; i++) {
            multiplicationResult[i] = number * (6 + i);
        }

        // Display the multiplication table from 6 to 9
        System.out.println("\nMultiplication Table for " + number + " from 6 to 9:");
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (6 + i) + " = " + multiplicationResult[i]);
        }

        // Close the scanner
        scanner.close();
    }
}
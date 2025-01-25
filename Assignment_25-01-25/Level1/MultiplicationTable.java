import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a number to print its multiplication table: ");
        int number = scanner.nextInt();

        // Define an integer array to store multiplication results
        int[] multiplicationTable = new int[10];

        // Calculate the multiplication table and store results in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        // Close the scanner
        scanner.close();
    }
}
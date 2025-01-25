import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Check if the input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            return;
        }

        // Create arrays for odd and even numbers
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];

        // Initialize index variables for odd and even arrays
        int evenIndex = 0;
        int oddIndex = 0;

        // Iterate from 1 to the entered number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print the odd numbers array
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print the even numbers array
        System.out.println("\n\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
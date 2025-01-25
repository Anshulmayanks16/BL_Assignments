import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the number of digits in the number
        int tempNumber = number;
        int count = 0;
        while (tempNumber != 0) {
            count++;
            tempNumber /= 10; // Remove last digit
        }

        // Create an array to store the digits of the number
        int[] digits = new int[count];
        tempNumber = number;
        
        // Store digits in the array
        for (int i = 0; i < count; i++) {
            digits[i] = tempNumber % 10;  // Get the last digit
            tempNumber /= 10;  // Remove the last digit
        }

        // Create another array to store the digits in reverse order (same as digits array)
        int[] reversedDigits = new int[count];

        // Copy digits from digits array to reversedDigits in reverse order
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - i - 1];
        }

        // Display the reversed number
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for a number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Convert the number into an array of digits
        int[] digits = new int[10];  // Array to store the frequency of digits (0 to 9)
        int[] frequency = new int[10];  // Frequency array to store the count of each digit

        // Extract digits from the number and store them in the digits array
        while (number > 0) {
            int digit = (int) (number % 10);  // Get the last digit
            frequency[digit]++;  // Increment the frequency of the digit
            number = number / 10;  // Remove the last digit
        }

        // Display the frequency of each digit (0 to 9)
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }

        scanner.close();
    }
}
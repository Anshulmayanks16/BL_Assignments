import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Initialize the sum and originalNumber
        int sum = 0;
        int originalNumber = number;

        // While loop to process each digit of the number
        while (number != 0) {
            // Find the last digit (reminder) of the number
            int digit = number % 10;

            // Find the cube of the digit and add it to the sum
            sum += digit * digit * digit;

            // Remove the last digit from the number
            number /= 10;
        }

        // Check if the sum of cubes is equal to the original number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        scanner.close();
    }
}
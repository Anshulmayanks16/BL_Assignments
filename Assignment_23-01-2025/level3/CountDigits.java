import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Handle the case of negative numbers
        number = Math.abs(number); // Take absolute value to ignore negative sign

        // Initialize the count variable to store the number of digits
        int count = 0;

        // Use a loop to count the digits
        while (number != 0) {
            number /= 10; // Remove the last digit
            count++; // Increase the digit count
        }

        // If the number is zero, it has one digit (special case)
        if (count == 0) {
            count = 1;
        }

        // Display the result
        System.out.println("The number of digits is: " + count);

        scanner.close();
    }
}
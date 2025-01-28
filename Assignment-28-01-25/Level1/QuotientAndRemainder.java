import java.util.Scanner;

public class QuotientAndRemainder {
    
    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];  // Array to store quotient and remainder
        result[0] = number / divisor;  // Quotient
        result[1] = number % divisor;  // Remainder
        return result;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input two integers
        System.out.print("Enter the first number: ");
        int number = scanner.nextInt();
        
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Ensure divisor is not zero
        if (divisor == 0) {
            System.out.println("Divisor cannot be zero!");
            return;
        }

        // Call the method to find quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);
        
        // Output the results
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);

        // Close the scanner
        scanner.close();
    }
}

import java.util.Scanner;

public class FactorialRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        int number = getInput(scanner);

        // Calculate factorial using recursion
        long result = factorial(number);

        // Display the result
        System.out.println("Factorial of " + number + " is: " + result);

        scanner.close();
    }

    // Function to get user input
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();
        return (num >= 0) ? num : 1; // Ensure valid input (default to 1 if negative)
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: 0! and 1! are 1
        }
        return n * factorial(n - 1); // Recursive case
    }
}

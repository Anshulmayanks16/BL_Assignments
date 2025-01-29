import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of terms from the user
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();

        // Generate and print the Fibonacci sequence
        System.out.println("Fibonacci Sequence:");
        generateFibonacci(terms);

        scanner.close();
    }

    // Function to generate and print Fibonacci sequence
    public static void generateFibonacci(int n) {
        int first = 0, second = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(first + " "); // Print current term
            int next = first + second; // Calculate next term
            first = second; // Shift first term
            second = next; // Shift second term
        }
        System.out.println(); // New line for formatting
    }
}
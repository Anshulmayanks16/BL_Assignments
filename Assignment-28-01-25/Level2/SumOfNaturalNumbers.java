import java.util.Scanner;

public class SumOfNaturalNumbers {
    
    // Method to find the sum of n natural numbers using recursion
    public static int sumRecursive(int n) {
        if (n == 0) {
            return 0;  // Base case: sum of 0 natural numbers is 0
        } else {
            return n + sumRecursive(n - 1);  // Recursive call
        }
    }

    // Method to find the sum of n natural numbers using the formula n*(n+1)/2
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input the value of n
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if n is a valid natural number
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;  // Exit if the input is not a natural number
        }

        // Calculate sum using recursion
        int recursiveSum = sumRecursive(n);
        
        // Calculate sum using the formula
        int formulaSum = sumFormula(n);

        // Print the results
        System.out.println("Sum of the first " + n + " natural numbers using recursion: " + recursiveSum);
        System.out.println("Sum of the first " + n + " natural numbers using the formula: " + formulaSum);

        // Compare both results
        if (recursiveSum == formulaSum) {
            System.out.println("Both methods produce the correct result.");
        } else {
            System.out.println("There is a discrepancy in the results.");
        }

        // Close the scanner
        scanner.close();
    }
}
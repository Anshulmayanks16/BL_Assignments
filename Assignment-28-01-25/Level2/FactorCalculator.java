import java.util.Scanner;

public class FactorCalculator {
    
    // Method to find the factors of a number and return them in an array
    public static int[] findFactors(int number) {
        // Count the number of factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array to store factors
        int[] factors = new int[count];
        int index = 0;

        // Save factors to the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to calculate the sum of the factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate the product of the factors
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate the sum of the squares of the factors
    public static double sumOfSquareOfFactors(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Call the method to find the factors
        int[] factors = findFactors(number);

        // Display the factors
        System.out.print("Factors of " + number + " are: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Calculate and display the sum of factors
        int sum = sumOfFactors(factors);
        System.out.println("Sum of the factors: " + sum);

        // Calculate and display the product of factors
        int product = productOfFactors(factors);
        System.out.println("Product of the factors: " + product);

        // Calculate and display the sum of squares of factors
        double sumOfSquares = sumOfSquareOfFactors(factors);
        System.out.println("Sum of the squares of the factors: " + sumOfSquares);

        // Close the scanner
        scanner.close();
    }
}
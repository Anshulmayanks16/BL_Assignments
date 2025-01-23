import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the input is a natural number (greater than 0)
        if (n <= 0) {
            System.out.println("Please enter a positive integer (natural number).");
        } else {
            // Compute sum using the formula n * (n + 1) / 2
            int formulaSum = n * (n + 1) / 2;

            // Compute sum using a while loop
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }

            // Compare both sums
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);

            // Check if both results are the same
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("There is an error in the computation.");
            }
        }

        scanner.close();
    }
}
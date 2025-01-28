import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to find the sum of n natural numbers using a loop
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter a positive integer: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Please enter a positive integer.");
            } else {
                // Calculate the sum of n natural numbers
                int sum = calculateSum(n);

                // Display the result
                System.out.printf("The sum of the first %d natural numbers is %d.%n", n, sum);
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
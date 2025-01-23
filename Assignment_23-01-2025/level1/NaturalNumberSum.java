import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input value for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is a natural number
        if (number > 0) {
            // Calculate the sum of the first 'n' natural numbers
            int sum = (number * (number + 1)) / 2;

            // Output the sum
            System.out.println("The sum of " + number + " natural numbers is: " + sum);
        } else {
            // If the number is not a natural number
            System.out.println("The number " + number + " is not a natural number");
        }

        scanner.close();
    }
}
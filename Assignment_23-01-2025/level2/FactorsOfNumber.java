import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input value for the number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
            return;
        }

        // Find and display the factors of the number
        System.out.println("The factors of " + number + " are:");
        for (int i = 1; i <= number; i++) { // Loop from 1 to the number
            if (number % i == 0) { // Check if number is perfectly divisible by i
                System.out.println(i); // Print the factor
            }
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the total to 0.0
        double total = 0.0;
        double userInput;

        // Start the loop to accept numbers until 0 is entered
        while (true) {
            // Prompt the user to enter a number
            System.out.print("Enter a number (or 0 to stop): ");
            userInput = scanner.nextDouble();

            // Check if the user entered 0 to exit the loop
            if (userInput == 0) {
                break;
            }

            // Add the entered number to the total
            total += userInput;
        }

        // Display the total sum
        System.out.println("The total sum is: " + total);

        scanner.close();
    }
}

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // Initialize scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Please enter a positive number: ");
        int number = scanner.nextInt();

        // Validate the input to ensure it's a positive number
        if (number > 0) {
            // Array to hold the results
            String[] output = new String[number];

            // Loop through numbers from 1 to the given number
            for (int i = 1; i <= number; i++) {
                // Check divisibility by 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    output[i - 1] = "FizzBuzz";
                } else if (i % 3 == 0) {
                    output[i - 1] = "Fizz";
                } else if (i % 5 == 0) {
                    output[i - 1] = "Buzz";
                } else {
                    output[i - 1] = Integer.toString(i);
                }
            }

            // Display results in the specified format
            for (int i = 0; i < output.length; i++) {
                System.out.println("Position " + (i + 1) + " = " + output[i]);
            }
        } else {
            System.out.println("You must enter a positive integer.");
        }

        scanner.close();
    }
}

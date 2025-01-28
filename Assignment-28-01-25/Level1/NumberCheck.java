import java.util.Scanner;

public class NumberCheck {

    // Method to check whether a number is positive, negative, or zero
    public static int checkNumber(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            // Check the number and get the result
            int result = checkNumber(number);

            // Display the result
            if (result == 1) {
                System.out.println("The number is positive.");
            } else if (result == -1) {
                System.out.println("The number is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
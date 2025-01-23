import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get inputs for number and power
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        // Initialize the result variable
        int result = 1;

        // Loop to calculate power
        for (int i = 1; i <= power; i++) {
            result *= number; // Multiply the result by the number in each iteration
        }

        // Display the result
        System.out.println(number + " raised to the power of " + power + " is: " + result);

        scanner.close();
    }
}
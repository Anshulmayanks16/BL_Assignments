import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize sum to store the sum of divisors
        int sum = 0;

        // Loop to find the divisors of the number and add them to sum
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {  // Check if i is a divisor
                sum += i;  // Add the divisor to sum
            }
        }

        // Check if the sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }

        scanner.close();
    }
}
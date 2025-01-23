import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Prime number check starts here
        boolean isPrime = true; // Assume the number is prime initially

        if (number <= 1) {
            // Numbers less than or equal to 1 are not prime
            isPrime = false;
        } else {
            // Check divisors from 2 to number - 1
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false; // Found a divisor, not prime
                    break;
                }
            }
        }

        // Output the result
        if (isPrime) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is NOT a Prime Number.");
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the input is a positive integer
        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
            return;
        }

        // FizzBuzz logic using a while loop
        System.out.println("\n--- FizzBuzz Output ---");
        int i = 1; // Initialize counter
        while (i <= number) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            i++; // Increment counter
        }

        scanner.close();
    }
}
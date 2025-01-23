import java.util.Scanner;

public class MultiplesBelow100 {
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

        // Find and display the multiples of the number below 100
        System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = 100; i >= 1; i--) { // Loop from 100 to 1
            if (i % number == 0) { // Check if i is a multiple of the number
                System.out.println(i); // Print the multiple
            }
        }

        scanner.close();
    }
}
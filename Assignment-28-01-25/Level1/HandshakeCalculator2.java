import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter the number of students: ");
            int n = scanner.nextInt();

            if (n < 2) {
                System.out.println("The number of students must be at least 2 to have a handshake.");
            } else {
                // Calculate maximum handshakes
                int maxHandshakes = calculateHandshakes(n);

                // Display the result
                System.out.printf("The maximum number of handshakes among %d students is %d.%n", n, maxHandshakes);
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid integer for the number of students.");
        } finally {
            scanner.close();
        }
    }
}

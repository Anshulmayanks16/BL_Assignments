import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the countdown start value from the user
        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();

        // Ensure the counter is a positive integer
        if (counter <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            // Countdown loop using a for loop
            for (int i = counter; i >= 1; i--) {
                System.out.println("T-minus " + i);
            }
            System.out.println("Liftoff!");
        }

        scanner.close();
    }
}
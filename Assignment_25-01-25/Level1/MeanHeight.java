import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        // Define a double array to store the heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0; // Variable to store the sum of all heights

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get input for the heights of 11 players
        System.out.println("Enter the heights of 11 players (in cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; // Add the height to the sum
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Display the mean height
        System.out.println("\nThe mean height of the football team is: " + mean + " cm");

        // Close the scanner
        scanner.close();
    }
}
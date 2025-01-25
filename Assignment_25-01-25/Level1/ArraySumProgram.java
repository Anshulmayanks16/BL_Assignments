import java.util.Scanner;

public class ArraySumProgram {
    public static void main(String[] args) {
        // Create an array to store up to 10 double values
        double[] numbers = new double[10];
        double total = 0.0; // Variable to store the total sum
        int index = 0; // Index for the array

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Use an infinite while loop to take input from the user
        System.out.println("Enter numbers (up to 10). Enter 0 or a negative number to stop:");
        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();

            // Check if the input is 0 or negative to break the loop
            if (input <= 0) {
                break;
            }

            // Break the loop if the array is full (index reaches 10)
            if (index == 10) {
                System.out.println("Array is full. No more numbers can be added.");
                break;
            }

            // Add the input to the array and increment the index
            numbers[index] = input;
            index++;
        }

        // Calculate the total sum of the numbers in the array
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display the numbers and the total sum
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("\nTotal sum of numbers: " + total);

        // Close the scanner
        scanner.close();
    }
}
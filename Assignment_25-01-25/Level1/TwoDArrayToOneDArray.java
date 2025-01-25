import java.util.Scanner;

public class TwoDArrayToOneDArray {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Validate input
        if (rows <= 0 || columns <= 0) {
            System.out.println("Error: Rows and columns must be positive integers.");
            return;
        }

        // Create and populate the 2D array
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element at (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create a 1D array to copy elements from the 2D array
        int[] array = new int[rows * columns];
        int index = 0; // To track the current index of the 1D array

        // Copy elements from the 2D array to the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 1D array
        System.out.println("\nElements of the 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
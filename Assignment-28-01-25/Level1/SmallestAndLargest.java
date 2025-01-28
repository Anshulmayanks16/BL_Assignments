import java.util.Scanner;

public class SmallestAndLargest {

    // Method to find the smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            System.out.print("Enter the third number: ");
            int number3 = scanner.nextInt();

            // Find the smallest and largest numbers
            int[] result = findSmallestAndLargest(number1, number2, number3);

            // Display the results
            System.out.printf("The smallest number is %d and the largest number is %d.%n", result[0], result[1]);
        } catch (Exception e) {
            System.out.println("Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
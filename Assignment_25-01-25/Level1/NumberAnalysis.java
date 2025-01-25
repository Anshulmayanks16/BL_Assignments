import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        // Define an integer array to store 5 numbers
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Take input for 5 numbers from the user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Analyze each number in the array
        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println("The number " + number + " is positive and even.");
                } else {
                    System.out.println("The number " + number + " is positive and odd.");
                }
            } else if (number < 0) {
                System.out.println("The number " + number + " is negative.");
            } else {
                System.out.println("The number " + number + " is zero.");
            }
        }

        // Compare the first and last elements of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        System.out.println("\nComparison of the first and last elements:");
        if (first == last) {
            System.out.println("The first element (" + first + ") and the last element (" + last + ") are equal.");
        } else if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        }

        // Close the scanner
        scanner.close();
    }
}
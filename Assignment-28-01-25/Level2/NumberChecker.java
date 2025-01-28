import java.util.Scanner;

public class NumberChecker {

    // Method to check whether the number is positive or negative
    public static String isPositive(int number) {
        if (number >= 0) {
            return "positive";
        } else {
            return "negative";
        }
    }

    // Method to check whether the number is even or odd
    public static String isEven(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    // Method to compare two numbers and return 1 if number1 > number2, 0 if both are equal, or -1 if number1 < number2
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an array to store the 5 numbers
        int[] numbers = new int[5];
        
        // Loop to take input for the 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            
            // Check if the number is positive or negative
            String positivity = isPositive(numbers[i]);
            if (positivity.equals("positive")) {
                // If positive, check if it's even or odd
                String evenOdd = isEven(numbers[i]);
                System.out.println("The number " + numbers[i] + " is positive and " + evenOdd + ".");
            } else {
                System.out.println("The number " + numbers[i] + " is negative.");
            }
        }
        
        // Compare the first and last element of the array
        int result = compare(numbers[0], numbers[4]);
        if (result == 1) {
            System.out.println("The first number is greater than the last number.");
        } else if (result == 0) {
            System.out.println("The first number is equal to the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }
        
        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}

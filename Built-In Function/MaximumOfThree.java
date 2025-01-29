import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get three numbers from the user
        int num1 = getInput("Enter the first number: ", scanner);
        int num2 = getInput("Enter the second number: ", scanner);
        int num3 = getInput("Enter the third number: ", scanner);

        // Find the maximum
        int max = findMax(num1, num2, num3);

        // Display the result
        System.out.println("The maximum number is: " + max);

        scanner.close();
    }

    // Function to take user input
    public static int getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to find the maximum of three numbers
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)); // Using Math.max for cleaner code
    }
}
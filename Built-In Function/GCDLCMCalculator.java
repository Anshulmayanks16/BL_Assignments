import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        int num1 = getInput("Enter the first number: ", scanner);
        int num2 = getInput("Enter the second number: ", scanner);

        // Calculate GCD and LCM
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        // Display the results
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);

        scanner.close();
    }

    // Function to get user input
    public static int getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using the formula: LCM(a, b) = (a * b) / GCD(a, b)
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
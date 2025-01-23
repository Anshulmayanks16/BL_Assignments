import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create variables for first and second numbers, and the operator
        double first, second;
        String op;
        
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Get input for first and second numbers and the operator
        System.out.print("Enter first number: ");
        first = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        second = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        op = scanner.next();
        
        // Perform operations based on the operator using switch...case
        switch(op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
                break;
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
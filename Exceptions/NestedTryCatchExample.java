import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50}; // Sample array
        
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        
        try {
            int value = numbers[index]; // May throw ArrayIndexOutOfBoundsException
            
            try {
                int result = value / divisor; // May throw ArithmeticException
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
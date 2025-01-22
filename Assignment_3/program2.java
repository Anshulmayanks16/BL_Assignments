import java.util.Scanner;

public class program2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = input.nextInt();

        System.out.print("Enter the value of b: ");
        int b = input.nextInt();

        System.out.print("Enter the value of c: ");
        int c = input.nextInt();

        // Performing the integer operations
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        // Printing the results
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
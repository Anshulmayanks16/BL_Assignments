import java.util.Scanner;

public class ChocolateDistribution {
    
    // Method to find the number of chocolates each child gets and the remaining chocolates
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];  // Array to store chocolates per child and remainder
        result[0] = numberOfChocolates / numberOfChildren;  // Chocolates each child gets
        result[1] = numberOfChocolates % numberOfChildren;  // Remaining chocolates
        return result;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input the number of chocolates and the number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Ensure the number of children is not zero to avoid division by zero
        if (numberOfChildren == 0) {
            System.out.println("The number of children cannot be zero!");
            return;
        }

        // Call the method to find chocolates per child and remaining chocolates
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        
        // Output the results
        System.out.println("Each child will get: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);

        // Close the scanner
        scanner.close();
    }
}
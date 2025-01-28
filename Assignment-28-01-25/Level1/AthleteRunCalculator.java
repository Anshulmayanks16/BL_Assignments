import java.util.Scanner;

public class AthleteRunCalculator {

    // Method to calculate the perimeter of the triangular park
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    // Method to calculate the number of rounds needed to complete 5 km
    public static double calculateRounds(double perimeter) {
        double distanceInMeters = 5000; // 5 km in meters
        return distanceInMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input for the sides of the triangular park
            System.out.print("Enter the length of side 1 (in meters): ");
            double side1 = scanner.nextDouble();

            System.out.print("Enter the length of side 2 (in meters): ");
            double side2 = scanner.nextDouble();

            System.out.print("Enter the length of side 3 (in meters): ");
            double side3 = scanner.nextDouble();

            // Calculate the perimeter of the triangular park
            double perimeter = calculatePerimeter(side1, side2, side3);

            // Calculate the number of rounds needed to complete 5 km
            double rounds = calculateRounds(perimeter);

            // Display the result
            System.out.printf("The athlete needs to complete %.2f rounds to run 5 km.%n", rounds);
        } catch (Exception e) {
            System.out.println("Please enter valid numeric inputs for the sides of the triangle.");
        } finally {
            scanner.close();
        }
    }
}
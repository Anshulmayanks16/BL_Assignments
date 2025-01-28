import java.util.Scanner;

public class EuclideanDistanceAndLineEquation {

    // Method to calculate the Euclidean distance between two points
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        // Calculate the distance using the formula
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate the slope and y-intercept of the line passing through the points
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        // Calculate the slope (m)
        double m = (y2 - y1) / (x2 - x1);
        
        // Calculate the y-intercept (b)
        double b = y1 - m * x1;

        // Return the slope and y-intercept as an array
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Take user input for the coordinates of the two points
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate and display the Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean distance between the points: %.2f\n", distance);

        // Calculate the line equation and display the slope and y-intercept
        double[] equation = findLineEquation(x1, y1, x2, y2);
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", equation[0], equation[1]);
    }
}
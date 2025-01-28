import java.util.Scanner;

public class Quadratic {

    // Method to find the roots of a quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c; // Delta (discriminant)

        if (delta > 0) {
            // Two real roots when delta is positive
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] { root1, root2 };
        } else if (delta == 0) {
            // One real root when delta is zero
            double root = -b / (2 * a);
            return new double[] { root };
        } else {
            // No real roots when delta is negative
            return new double[0]; // Returning empty array for no real roots
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for a, b, and c
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        // Call the method to find the roots
        double[] roots = findRoots(a, b, c);

        // Display the roots
        if (roots.length == 0) {
            System.out.println("No real roots exist for the given equation.");
        } else if (roots.length == 1) {
            System.out.println("There is one real root: " + roots[0]);
        } else {
            System.out.println("The two real roots are: " + roots[0] + " and " + roots[1]);
        }

        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}
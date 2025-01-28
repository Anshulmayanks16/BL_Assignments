import java.util.Scanner;

public class TrigonometricCalculator {
    
    // Method to calculate trigonometric functions: sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert angle from degrees to radians
        double radians = Math.toRadians(angle);
        
        // Calculate sine, cosine, and tangent using Math class functions
        double[] results = new double[3];
        results[0] = Math.sin(radians);  // Sine of the angle
        results[1] = Math.cos(radians);  // Cosine of the angle
        results[2] = Math.tan(radians);  // Tangent of the angle
        
        return results;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input the angle in degrees
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        // Call the method to calculate trigonometric functions
        double[] results = calculateTrigonometricFunctions(angle);

        // Output the results
        System.out.println("Sine of the angle: " + results[0]);
        System.out.println("Cosine of the angle: " + results[1]);
        System.out.println("Tangent of the angle: " + results[2]);

        // Close the scanner
        scanner.close();
    }
}


import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        // Create arrays to store weight, height, BMI, and weight status for each person
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        // Take input for weight and height for each person
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter the weight (in kg) for person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter the height (in meters) for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();

            // Calculate BMI for each person
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            // Determine weight status based on BMI
            if (bmis[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display height, weight, BMI, and weight status for each person
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", (i + 1), heights[i], weights[i], bmis[i], weightStatus[i]);
        }

        scanner.close();
    }
}
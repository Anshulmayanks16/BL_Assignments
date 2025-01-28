import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and populate the array
    public static void calculateBMI(double[][] bmiData) {
        for (int i = 0; i < bmiData.length; i++) {
            double weight = bmiData[i][0]; // weight in kg
            double heightInMeters = bmiData[i][1] / 100; // height in meters
            double bmi = weight / (heightInMeters * heightInMeters); // BMI calculation
            bmiData[i][2] = bmi; // Store the BMI in the third column
        }
    }

    // Method to determine the BMI status
    public static String[] determineBMIStatus(double[][] bmiData) {
        String[] bmiStatus = new String[bmiData.length];
        for (int i = 0; i < bmiData.length; i++) {
            double bmi = bmiData[i][2];
            if (bmi < 18.5) {
                bmiStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                bmiStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                bmiStatus[i] = "Overweight";
            } else {
                bmiStatus[i] = "Obese";
            }
        }
        return bmiStatus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a 2D array to store weight, height, and BMI for 10 people
        double[][] bmiData = new double[10][3]; // 10 rows, 3 columns (weight, height, BMI)
        
        // Input the weight and height of each person
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (in kg): ");
            bmiData[i][0] = scanner.nextDouble(); // Weight in kg
            System.out.print("Height (in cm): ");
            bmiData[i][1] = scanner.nextDouble(); // Height in cm
        }
        
        // Calculate the BMI for each person
        calculateBMI(bmiData);
        
        // Determine the BMI status for each person
        String[] bmiStatus = determineBMIStatus(bmiData);
        
        // Display the results
        System.out.println("\nBMI Report:");
        System.out.println("----------------------------------------------------");
        System.out.println("Person\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        System.out.println("----------------------------------------------------");
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", (i + 1), bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiStatus[i]);
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
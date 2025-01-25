import java.util.Scanner;

public class BMICalculatorWith2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        // Create a 2D array to store weight, height, and BMI for each person
        double[][] personData = new double[numPersons][3];  // personData[i][0] = weight, personData[i][1] = height, personData[i][2] = BMI
        String[] weightStatus = new String[numPersons]; // Array to store weight status

        // Take input for weight and height for each person
        for (int i = 0; i < numPersons; i++) {
            // Ensure valid input for weight and height
            do {
                System.out.print("Enter the weight (in kg) for person " + (i + 1) + ": ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Please enter a valid positive weight.");
                }
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter the height (in meters) for person " + (i + 1) + ": ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Please enter a valid positive height.");
                }
            } while (personData[i][1] <= 0);

            // Calculate BMI and store it in the personData array
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // Determine weight status based on BMI
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display height, weight, BMI, and weight status for each person
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
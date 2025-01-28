import java.util.Random;

public class ZaraBonusCalculator {

    // Method to determine the salary and years of service
    public static int[][] getEmployeeDetails(int numEmployees) {
        Random rand = new Random();
        int[][] employeeDetails = new int[numEmployees][2]; // 2D array: [0] - Salary, [1] - Years of Service

        for (int i = 0; i < numEmployees; i++) {
            // Generate a random salary between 10000 and 99999 (5-digit salary)
            employeeDetails[i][0] = rand.nextInt(90000) + 10000;
            // Generate a random years of service between 1 and 20
            employeeDetails[i][1] = rand.nextInt(20) + 1;
        }
        return employeeDetails;
    }

    // Method to calculate the new salary and bonus based on years of service
    public static double[][] calculateNewSalaryAndBonus(int[][] employeeDetails) {
        double[][] newSalaryAndBonus = new double[employeeDetails.length][3]; // 2D array: [0] - Old Salary, [1] - New Salary, [2] - Bonus

        for (int i = 0; i < employeeDetails.length; i++) {
            int oldSalary = employeeDetails[i][0];
            int yearsOfService = employeeDetails[i][1];

            double bonusPercentage = (yearsOfService > 5) ? 0.05 : 0.02;
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;

            newSalaryAndBonus[i][0] = oldSalary;
            newSalaryAndBonus[i][1] = newSalary;
            newSalaryAndBonus[i][2] = bonus;
        }
        return newSalaryAndBonus;
    }

    // Method to calculate the sum of old salary, new salary, and total bonus
    public static void calculateTotalAmounts(double[][] newSalaryAndBonus) {
        double sumOldSalary = 0;
        double sumNewSalary = 0;
        double totalBonus = 0;

        for (int i = 0; i < newSalaryAndBonus.length; i++) {
            sumOldSalary += newSalaryAndBonus[i][0];
            sumNewSalary += newSalaryAndBonus[i][1];
            totalBonus += newSalaryAndBonus[i][2];
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Total Old Salary: " + sumOldSalary);
        System.out.println("Total New Salary: " + sumNewSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("-------------------------------------------------");
    }

    // Method to display employee details in tabular format
    public static void displayEmployeeDetails(double[][] newSalaryAndBonus) {
        System.out.println("Employee | Old Salary | New Salary | Bonus");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < newSalaryAndBonus.length; i++) {
            System.out.printf("%d        | %.2f      | %.2f       | %.2f\n", 
                              i + 1, newSalaryAndBonus[i][0], newSalaryAndBonus[i][1], newSalaryAndBonus[i][2]);
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        // Get employee details (salary and years of service)
        int[][] employeeDetails = getEmployeeDetails(numEmployees);

        // Calculate the new salary and bonus
        double[][] newSalaryAndBonus = calculateNewSalaryAndBonus(employeeDetails);

        // Display the results in tabular format
        displayEmployeeDetails(newSalaryAndBonus);

        // Calculate and display the total amounts
        calculateTotalAmounts(newSalaryAndBonus);
    }
}
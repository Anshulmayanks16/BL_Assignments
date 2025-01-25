import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to hold salary, years of service, bonus, and new salary for 10 employees
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        // Variables to calculate total bonus, old salary, and new salary
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Loop to input salary and years of service for 10 employees
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            // Loop to validate salary input
            while (true) {
                System.out.print("Enter salary for Employee " + (i + 1) + ": ");
                salaries[i] = scanner.nextDouble();
                if (salaries[i] <= 0) {
                    System.out.println("Salary must be a positive number. Please enter again.");
                } else {
                    break;
                }
            }

            // Loop to validate years of service input
            while (true) {
                System.out.print("Enter years of service for Employee " + (i + 1) + ": ");
                yearsOfService[i] = scanner.nextDouble();
                if (yearsOfService[i] < 0) {
                    System.out.println("Years of service cannot be negative. Please enter again.");
                } else {
                    break;
                }
            }
        }

        // Loop to calculate bonus, new salary, and total salaries
        for (int i = 0; i < 10; i++) {
            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05;  // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02;  // 2% bonus
            }

            // Calculate new salary
            newSalaries[i] = salaries[i] + bonuses[i];

            // Update totals
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Output total bonus, old salary, and new salary
        System.out.println("\nTotal Bonus to be paid: " + totalBonus);
        System.out.println("Total old salary of all employees: " + totalOldSalary);
        System.out.println("Total new salary of all employees: " + totalNewSalary);

        // Display details for each employee
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.println("Old Salary: " + salaries[i]);
            System.out.println("Years of Service: " + yearsOfService[i]);
            System.out.println("Bonus: " + bonuses[i]);
            System.out.println("New Salary: " + newSalaries[i]);
        }

        scanner.close();
    }
}
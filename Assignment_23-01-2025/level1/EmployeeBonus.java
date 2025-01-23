import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for salary and years of service
        System.out.print("Enter employee's salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter employee's years of service: ");
        int yearsOfService = scanner.nextInt();

        // Check if the employee qualifies for a bonus (more than 5 years of service)
        if (yearsOfService > 5) {
            // Calculate bonus (5% of salary)
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus for employees with less than or equal to 5 years of service.");
        }

        scanner.close();
    }
}

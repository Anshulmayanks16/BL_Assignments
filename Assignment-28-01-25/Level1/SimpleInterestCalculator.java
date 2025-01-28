import java.util.Scanner;

public class SimpleInterestCalculator {

    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter the Principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the Rate of Interest (in %): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the Time (in years): ");
            double time = scanner.nextDouble();

            // Calculate simple interest
            double simpleInterest = calculateSimpleInterest(principal, rate, time);

            // Display the result
            System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f%%, and Time %.2f years.%n", 
                              simpleInterest, principal, rate, time);
        } catch (Exception e) {
            System.out.println("Please enter valid numeric inputs for Principal, Rate, and Time.");
        } finally {
            scanner.close();
        }
    }
}
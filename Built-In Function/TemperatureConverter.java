import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu for conversion choice
        System.out.println("Temperature Converter:");
        System.out.println("1. Convert Fahrenheit to Celsius");
        System.out.println("2. Convert Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        // Get temperature input
        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        // Perform conversion based on user choice
        if (choice == 1) {
            System.out.println("Converted Temperature: " + fahrenheitToCelsius(temperature) + "°C");
        } else if (choice == 2) {
            System.out.println("Converted Temperature: " + celsiusToFahrenheit(temperature) + "°F");
        } else {
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }

        scanner.close();
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
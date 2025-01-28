import java.util.Scanner;

public class WindChillCalculator {
    
    // Method to calculate the wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        // Formula to calculate wind chill temperature
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input temperature and wind speed
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();

        // Call the method to calculate wind chill temperature
        double windChill = calculateWindChill(temperature, windSpeed);

        // Output the result
        System.out.println("The wind chill temperature is: " + windChill);

        // Close the scanner
        scanner.close();
    }
}
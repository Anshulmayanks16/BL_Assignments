import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for weight and height
        System.out.print("Enter weight in kilograms (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in centimeters (cm):
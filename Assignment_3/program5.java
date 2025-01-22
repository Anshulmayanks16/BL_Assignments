import java.util.Scanner;

public class program5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        double celsiusResult = (fahrenheit - 32) * 5/9;

        System.out.println(fahrenheit + " Fahrenheit is " + celsiusResult + " Celsius");
    }
}
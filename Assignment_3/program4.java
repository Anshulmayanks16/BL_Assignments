import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheitResult = (celsius * 9/5) + 32;

        System.out.println(celsius + " Celsius is " + fahrenheitResult + " Fahrenheit");
    }
}
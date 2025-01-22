import java.util.Scanner;

public class program12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight in pounds: ");
        double pounds = input.nextDouble();

        double kilograms = pounds * 2.2;

        System.out.println("The weight of the person in pound is " + pounds + " and in kg is " + kilograms);
    }
}
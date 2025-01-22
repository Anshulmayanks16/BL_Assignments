import java.util.Scanner;

public class program9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;
        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds);
    }
}
import java.util.Scanner;

public class program12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in centimeters: ");
        double baseCm = input.nextDouble();

        System.out.print("Enter the height of the triangle in centimeters: ");
        double heightCm = input.nextDouble();

        double areaCm2 = 0.5 * baseCm * heightCm;
        double areaInches2 = areaCm2 / 6.4516;

        System.out.println("The area of the triangle is " + areaCm2 + " square centimeters and " + areaInches2 + " square inches.");
    }
}
import java.util.Scanner;

public class CollinearPoints {

    // Method to check if three points are collinear using slope formula
    public static boolean arePointsCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Checking if slopes AB and BC are equal
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        
        // If slopes AB and BC are equal, then the points are collinear
        return slopeAB == slopeBC;
    }

    // Method to check if three points are collinear using area formula
    public static boolean arePointsCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Using the area formula
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for three points
        System.out.print("Enter x1, y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Enter x2, y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.print("Enter x3, y3: ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        // Check if the points are collinear by slope method
        boolean isCollinearBySlope = arePointsCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear by slope method? " + isCollinearBySlope);

        // Check if the points are collinear by area method
        boolean isCollinearByArea = arePointsCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear by area method? " + isCollinearByArea);

        // Check if both methods agree
        if (isCollinearBySlope && isCollinearByArea) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }
    }
}
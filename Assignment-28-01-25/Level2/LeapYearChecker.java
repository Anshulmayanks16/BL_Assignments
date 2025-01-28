import java.util.Scanner;

public class LeapYearChecker {
    
    // Method to check if the year is a leap year
    public static boolean isLeapYear(int year) {
        // Check if the year is greater than or equal to 1582 (Gregorian calendar)
        if (year < 1582) {
            System.out.println("Year should be greater than or equal to 1582 (Gregorian calendar).");
            return false;
        }

        // Check the leap year conditions:
        // Year should be divisible by 4 and (not divisible by 100 or divisible by 400)
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Input the year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        // Close the scanner
        scanner.close();
    }
}
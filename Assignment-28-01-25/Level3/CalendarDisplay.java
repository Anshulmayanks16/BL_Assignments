import java.util.Scanner;

public class CalendarDisplay {

    // Method to get the name of the month
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to check if the year is a leap year
    public static boolean isLeapYear(int year) {
        // Leap year is divisible by 4, but not divisible by 100, except when divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get the number of days in a month
    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // For February, check if it's a leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    // Method to get the first day of the month using the Gregorian algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        
        // Adjust the month and year for the Gregorian algorithm
        if (m < 3) {
            m += 12;
            y -= 1;
        }

        // Calculate the first day of the month (0=Sunday, 1=Monday, ..., 6=Saturday)
        int x = y + y / 4 - y / 100 + y / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;

        return d0;
    }

    // Method to display the calendar for the given month and year
    public static void displayCalendar(int month, int year) {
        // Get the name of the month
        String monthName = getMonthName(month);
        int numberOfDays = getNumberOfDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        // Display the month and year
        System.out.printf("    %s %d\n", monthName, year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop to display leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); // 4 spaces for indentation
        }

        // Second loop to display the days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d ", day);  // Format the day with 3 spaces
            if ((firstDay + day) % 7 == 0) {
                System.out.println();  // Newline after Saturday
            }
        }

        System.out.println();  // Move to the next line after the last day of the month
    }

    public static void main(String[] args) {
        // Take month and year as input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // Display the calendar for the given month and year
        displayCalendar(month, year);
    }
}
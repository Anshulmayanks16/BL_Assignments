import java.util.Scanner;

public class SpringSeason {

    // Method to check if the date falls in the Spring Season
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20 && day <= 31) || 
            (month == 4 && day >= 1 && day <= 30) || 
            (month == 5 && day >= 1 && day <= 31) || 
            (month == 6 && day >= 1 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter the month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Enter the day (1-31): ");
            int day = scanner.nextInt();

            // Check if it's a Spring Season
            boolean isSpring = isSpringSeason(month, day);

            // Display the result
            if (isSpring) {
                System.out.println("It's a Spring Season.");
            } else {
                System.out.println("Not a Spring Season.");
            }
        } catch (Exception e) {
            System.out.println("Please enter valid integers for month and day.");
        } finally {
            scanner.close();
        }
    }
}
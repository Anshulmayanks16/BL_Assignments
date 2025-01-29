import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input date
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        
        // Parse the input string to a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Perform date arithmetic
        LocalDate newDate = date.plusDays(7)         // Add 7 days
                                .plusMonths(1)     // Add 1 month
                                .plusYears(2)      // Add 2 years
                                .minusWeeks(3);    // Subtract 3 weeks

        // Display the resulting date
        System.out.println("Original Date: " + date);
        System.out.println("Modified Date: " + newDate);
        
        scanner.close();
    }
}
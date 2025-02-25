import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVDataValidator {

    public static void main(String[] args) {
        String filePath = "New folder/Employee.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String phoneNumberRegex = "^\\d{10,13}$";
        Pattern phonePattern = Pattern.compile(phoneNumberRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();  // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                // Debugging: Print the current row (nextLine) to verify CSV content
                System.out.println("Reading row: " + String.join(",", nextLine));

                if (nextLine.length < 6) {
                    System.out.println("Invalid row (less than 6 columns): " + String.join(",", nextLine));
                    continue;
                }

                String name = nextLine[1];
                String email = nextLine[4];
                String phoneNumber = nextLine[5];

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email for " + name + ": " + email);
                }

                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number for " + name + ": " + phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

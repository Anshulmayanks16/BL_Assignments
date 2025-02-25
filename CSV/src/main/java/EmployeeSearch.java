import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class EmployeeSearch {

    public static void main(String[] args) {
        String filePath = "New folder/Employee.csv";
        String searchName = "Ravi";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean found = false;

            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                String employeeName = nextLine[1];
                if (employeeName.equalsIgnoreCase(searchName)) {
                    String department = nextLine[2];
                    String salary = nextLine[3];
                    System.out.println("Employee: " + employeeName);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

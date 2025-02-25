import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class EmployeeDetails {

    public static void main(String[] args) {
        String filePath = "New folder/Employee.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;


            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String employeeID = nextLine[0];
                String employeeName = nextLine[1];
                String employeeDepartment = nextLine[2];
                String employeeSalary = nextLine[3];

                System.out.println("Employee ID: " + employeeID);
                System.out.println("Name: " + employeeName);
                System.out.println("Department: " + employeeDepartment);
                System.out.println("Salary: " + employeeSalary);
                System.out.println("--------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

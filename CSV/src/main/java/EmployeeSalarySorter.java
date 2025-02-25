import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EmployeeSalarySorter {

    public static void main(String[] args) {
        String filePath = "New folder/Employee.csv";
        List<String[]> employeeRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                employeeRecords.add(nextLine);
            }

            employeeRecords.sort((record1, record2) -> {
                double salary1 = Double.parseDouble(record1[3]); // Salary is at index 3
                double salary2 = Double.parseDouble(record2[3]);
                return Double.compare(salary2, salary1);  // Descending order
            });

            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < 5 && i < employeeRecords.size(); i++) {
                String[] record = employeeRecords.get(i);
                String employeeName = record[1];
                String department = record[2];
                String salary = record[3];
                System.out.println("Name: " + employeeName + ", Department: " + department + ", Salary: " + salary);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

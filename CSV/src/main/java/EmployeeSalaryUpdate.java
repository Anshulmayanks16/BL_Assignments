import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeSalaryUpdate {

    public static void main(String[] args) {
        String inputFilePath = "New folder/Employee.csv";
        String outputFilePath = "New folder/updated_employee.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> allRecords = reader.readAll();
            writer.writeNext(allRecords.get(0));

            for (int i = 1; i < allRecords.size(); i++) {
                String[] record = allRecords.get(i);
                String department = record[2];
                String salaryStr = record[3];

                if (department.equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(salaryStr);
                    salary *= 1.10;
                    record[3] = String.format("%.2f", salary);
                }

                writer.writeNext(record);
            }

            System.out.println("Employee salaries updated and saved to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVReportGenerator {

    public static void main(String[] args) {
        String inputFile = "New folder/Employee.csv";
        String outputFile = "employee_report.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records = reader.readAll();


            writer.writeNext(records.get(0)); // Assuming the first row contains headers

            for (int i = 1; i < records.size(); i++) {
                writer.writeNext(records.get(i)); // Writing each record to the output CSV file
            }

            System.out.println("Report generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}

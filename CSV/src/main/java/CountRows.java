import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CountRows {

    public static void main(String[] args) {
        String filePath = "New folder/Employee.csv";

        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;


            reader.readNext();


            while ((nextLine = reader.readNext()) != null) {
                rowCount++;
            }

            System.out.println("Total number of employee records (excluding header): " + rowCount);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

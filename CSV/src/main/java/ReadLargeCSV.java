import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {

    public static void main(String[] args) {
        String filePath = "New folder/large_file.csv";
        int batchSize = 100;
        int recordCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            int processedCount = 0;


            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                processedCount++;
                recordCount++;

                if (processedCount == batchSize) {
                    System.out.println("Processed " + batchSize + " records...");
                    processedCount = 0;
                }
            }

            if (processedCount > 0) {
                System.out.println("Processed " + processedCount + " records...");
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

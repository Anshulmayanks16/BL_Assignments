import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {

    public static void main(String[] args) {
        String filePath = "New folder/Large_file.csv";
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String record = String.join(",", nextLine);

                if (seenIds.contains(id)) {

                    duplicateRecords.add(record);
                } else {

                    seenIds.add(id);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                duplicateRecords.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVfiles {

    public static void main(String[] args) {
        String filePath1 = "New folder/student.csv";
        String filePath2 = "New folder/student2.csv";
        String outputFilePath = "merged_students.csv";

        Map<Integer, String[]> studentsMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(filePath1));
             CSVReader reader2 = new CSVReader(new FileReader(filePath2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            String[] header1 = reader1.readNext();
            String[] header2 = reader2.readNext();

            String[] outputHeader = new String[header1.length + header2.length - 1];
            System.arraycopy(header1, 0, outputHeader, 0, header1.length);
            System.arraycopy(header2, 1, outputHeader, header1.length, header2.length - 1);
            writer.writeNext(outputHeader);

            String[] nextLine;
            while ((nextLine = reader1.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                studentsMap.put(id, nextLine);
            }

            while ((nextLine = reader2.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                if (studentsMap.containsKey(id)) {
                    String[] student1 = studentsMap.get(id);
                    String[] mergedRecord = new String[student1.length + nextLine.length - 1];
                    System.arraycopy(student1, 0, mergedRecord, 0, student1.length);
                    System.arraycopy(nextLine, 1, mergedRecord, student1.length, nextLine.length - 1);
                    writer.writeNext(mergedRecord);
                }
            }

            System.out.println("Merged CSV file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

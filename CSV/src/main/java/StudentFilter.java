import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class StudentFilter {

    public static void main(String[] args) {
        String filePath = "New folder/student.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                String studentID = nextLine[0];
                String studentName = nextLine[1];
                int studentMarks = Integer.parseInt(nextLine[3]);

                if (studentMarks > 80) {
                    System.out.println("ID: " + studentID + ", Name: " + studentName + ", Marks: " + studentMarks);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

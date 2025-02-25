import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class StudentDetails {

    public static void main(String[] args) {
        String filePath = "New folder/student.csv";


        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String studentID = nextLine[0];
                String studentName = nextLine[1];
                String studentAge = nextLine[2];
                String studentMarks = nextLine[3];

                System.out.println("Student ID: " + studentID);
                System.out.println("Name: " + studentName);
                System.out.println("Age: " + studentAge);
                System.out.println("Marks: " + studentMarks);
                System.out.println("--------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

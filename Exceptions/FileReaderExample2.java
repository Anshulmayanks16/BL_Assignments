import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "E:\Capgemini Training\Assignments\Exceptions";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
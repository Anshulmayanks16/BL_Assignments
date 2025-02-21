import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "E:\Capgemini Training\Assignments"; // File to read

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file path

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
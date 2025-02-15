import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change this to your desired file path

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath, true); // Append mode enabled
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine(); // Write each input as a new line
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
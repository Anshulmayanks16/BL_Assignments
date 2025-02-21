import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "user_data.txt";
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {
            
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            
            System.out.println("User data saved successfully in " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading input or writing to file.");
        }
    }
}
import java.io.*;

public class DataStreamsStudent {
    private static final String FILE_NAME = "student_data.dat";
    
    public static void main(String[] args) {
        // Writing student data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101); // Roll number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA
            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        
        // Reading student data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            
            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
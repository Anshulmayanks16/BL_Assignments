import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "large_source.txt";
        String destinationFile = "large_destination.txt";
        
        long startTime, endTime;
        
        // Using Buffered Streams
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            
            startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            
            System.out.println("Buffered Streams Copy Time: " + (endTime - startTime) + " ns");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error reading or writing file.");
        }
    }
}
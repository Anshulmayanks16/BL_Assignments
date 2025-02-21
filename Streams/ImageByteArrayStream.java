import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayStream {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "copied.jpg";

        try {
            // Read image file into byte array
            byte[] imageBytes = Files.readAllBytes(new File(sourceImage).toPath());
            
            // Convert byte array back to image
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destinationImage)) {
                
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                
                System.out.println("Image copied successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error processing image file: " + e.getMessage());
        }
    }
}
import com.opencsv.CSVWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JSONToCSVToJSON {

    public static void main(String[] args) {
        String jsonFilePath = "New folder/students.json";  // Ensure this path is correct
        String csvFilePath = "New folder/student.csv";     // Ensure this path is correct
        convertJSONToCSV(jsonFilePath, csvFilePath);
        convertCSVToJSON(csvFilePath, "converted_students.json");
    }


    public static void convertJSONToCSV(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode studentsNode = objectMapper.readTree(new java.io.File(jsonFilePath));

            if (studentsNode.isEmpty()) {
                System.out.println("JSON file is empty or not properly formatted.");
                return;
            }

            CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
            Iterator<JsonNode> elements = studentsNode.elements();
            boolean firstRow = true;

            while (elements.hasNext()) {
                JsonNode student = elements.next();

                String[] row = {
                        student.get("id").asText(),
                        student.get("name").asText(),
                        student.get("age").asText(),
                        student.get("grade").asText()
                };


                if (firstRow) {
                    writer.writeNext(new String[] {"ID", "Name", "Age", "Grade"});
                    firstRow = false;
                }


                writer.writeNext(row);
            }

            writer.close();
            System.out.println("CSV file created successfully: " + csvFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void convertCSVToJSON(String csvFilePath, String jsonFilePath) {
        try {
            CSVReader reader = new CSVReader(new FileReader(csvFilePath));
            String[] header = reader.readNext();  // Read header
            String[] record;
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("[");

            while ((record = reader.readNext()) != null) {
                jsonBuilder.append("{");
                for (int i = 0; i < header.length; i++) {
                    jsonBuilder.append("\"").append(header[i]).append("\": \"").append(record[i]).append("\", ");
                }
                jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length());  // Remove trailing comma
                jsonBuilder.append("}, ");
            }

            if (jsonBuilder.length() > 1) {
                jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length());
            }
            jsonBuilder.append("]");


            java.nio.file.Files.write(java.nio.file.Paths.get(jsonFilePath), jsonBuilder.toString().getBytes());
            reader.close();
            System.out.println("JSON file created successfully: " + jsonFilePath);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

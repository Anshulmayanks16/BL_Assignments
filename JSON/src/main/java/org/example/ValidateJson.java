package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonString = "{"name":"John", "age":30}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Validate JSON structure
            JsonNode rootNode = objectMapper.readTree(jsonString);
            if (rootNode.has("name") && rootNode.has("age")) {
                System.out.println("Valid JSON structure");
            } else {
                System.out.println("Invalid JSON structure");
            }
        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}

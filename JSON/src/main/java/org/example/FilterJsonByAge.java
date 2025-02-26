import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class FilterJsonByAge {
    public static void main(String[] args) throws IOException {
        // JSON array as a string
        String jsonArray = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Alice\", \"age\":24}, {\"name\":\"Bob\", \"age\":28}]";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the JSON array string into a JsonNode
        JsonNode arrayNode = objectMapper.readTree(jsonArray);

        // Iterate over the JSON array and filter out records where age > 25
        Iterator<JsonNode> elements = arrayNode.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            if (node.get("age").asInt() > 25) {
                System.out.println(node.toString());
            }
        }
    }
}

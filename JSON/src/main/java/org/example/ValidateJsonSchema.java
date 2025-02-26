import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class ValidateJsonSchema {
    public static void main(String[] args) {
        String schemaString = "{ "type": "object", "properties": { "email": {"type": "string", "format": "email"} }, "required": ["email"] }";
        String jsonString = "{ "email": "test@example.com" }";
        
        JSONObject jsonSchema = new JSONObject(schemaString);
        JSONObject jsonData = new JSONObject(jsonString);
        
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonData);
        
        System.out.println("JSON is valid against the schema.");
    }
}
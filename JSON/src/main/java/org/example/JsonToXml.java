import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) {
        String jsonString = "{ "name":"Alice", "age":30, "city":"New York" }";
        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);
        
        System.out.println("<root>" + xml + "</root>");
    }
}
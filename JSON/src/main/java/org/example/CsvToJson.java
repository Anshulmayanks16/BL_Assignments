import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("data.csv"));
        String[] headers = lines.get(0).split(",");
        JSONArray jsonArray = new JSONArray();
        
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            JSONObject json = new JSONObject();
            for (int j = 0; j < headers.length; j++) {
                json.put(headers[j], values[j]);
            }
            jsonArray.put(json);
        }
        
        System.out.println(jsonArray.toString(2));
    }
}
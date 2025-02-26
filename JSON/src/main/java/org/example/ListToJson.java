import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;

public class ListToJson {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        JSONArray jsonArray = new JSONArray(names);
        System.out.println(jsonArray.toString(2));
    }
}
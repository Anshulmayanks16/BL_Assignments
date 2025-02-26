import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonFile {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("data.json")));
        JSONObject json = new JSONObject(content);
        System.out.println(json.toString(2));
    }
}
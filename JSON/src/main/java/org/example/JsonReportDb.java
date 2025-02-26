import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class JsonReportDb {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM records");
        
        JSONArray jsonArray = new JSONArray();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            json.put("id", rs.getInt("id"));
            json.put("name", rs.getString("name"));
            json.put("value", rs.getDouble("value"));
            jsonArray.put(json);
        }
        
        System.out.println(jsonArray.toString(2));
        conn.close();
    }
}
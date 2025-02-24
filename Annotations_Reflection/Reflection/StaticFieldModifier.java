import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class StaticFieldModifier {
    public static void main(String[] args) {
        try {
            Field field = Configuration.class.getDeclaredField("API_KEY");
            field.setAccessible(true);
            field.set(null, "UPDATED_KEY");

            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            throw new RuntimeException("Reflection error", e);
        }
    }
}

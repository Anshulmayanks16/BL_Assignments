import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Map<String, Object> jsonMap = new HashMap<>();
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    String key = field.getAnnotation(JsonField.class).name();
                    Object value = field.get(obj);
                    jsonMap.put(key, value);
                }
            }
            return new Gson().toJson(jsonMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Serialization error", e);
        }
    }
}

public class JsonAnnotationExample {
    public static void main(String[] args) {
        User user = new User("Alice", 25);
        System.out.println(JsonSerializer.serialize(user));
    }
}

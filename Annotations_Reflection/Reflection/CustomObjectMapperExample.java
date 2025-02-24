import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping error", e);
        }
    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class CustomObjectMapperExample {
    public static void main(String[] args) {
        Map<String, Object> data = Map.of("name", "Alice", "age", 25);
        User user = ObjectMapper.toObject(User.class, data);
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
    }
}

import java.lang.reflect.Field;
import java.util.StringJoiner;

class JsonConverter {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            StringJoiner json = new StringJoiner(", ", "{", "}");
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(obj);
                String formattedValue = (value instanceof String) ? "\"" + value + "\"" : value.toString();
                json.add("\"" + key + "\": " + formattedValue);
            }
            return json.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("JSON conversion error", e);
        }
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonRepresentationExample {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        System.out.println(JsonConverter.toJson(person));
    }
}

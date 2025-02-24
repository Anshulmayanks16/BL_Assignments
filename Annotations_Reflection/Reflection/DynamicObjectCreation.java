import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");

            Object obj1 = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Student 1: " + ((Student) obj1).getName());

            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            Object obj2 = constructor.newInstance("Alice");
            System.out.println("Student 2: " + ((Student) obj2).getName());
        } catch (Exception e) {
            throw new RuntimeException("Reflection error", e);
        }
    }
}

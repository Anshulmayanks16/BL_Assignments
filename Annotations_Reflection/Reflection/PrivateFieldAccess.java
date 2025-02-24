import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) {
        try {
            Person person = new Person(30);
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            System.out.println("Original Age: " + ageField.get(person));

            ageField.set(person, 40);
            System.out.println("Modified Age: " + ageField.get(person));
        } catch (Exception e) {
            throw new RuntimeException("Reflection error", e);
        }
    }
}


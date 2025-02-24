import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.validate(username);
        this.username = username;
    }

    private void validate(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters");
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Validation error", e);
        }
    }
}

public class MaxLengthValidator {
    public static void main(String[] args) {
        new User("ShortName");
        new User("ThisNameIsTooLong");
    }
}

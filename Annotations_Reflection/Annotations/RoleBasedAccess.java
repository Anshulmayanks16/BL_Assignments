import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class UserService {
    
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted.");
    }
}

class RoleValidator {
    private String currentUserRole;

    public RoleValidator(String role) {
        this.currentUserRole = role;
    }

    public void executeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!currentUserRole.equals(requiredRole)) {
                    System.out.println("Access Denied!");
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("Error executing method", e);
        }
    }
}

public class RoleBasedAccess {
    public static void main(String[] args) {
        UserService service = new UserService();
        RoleValidator admin = new RoleValidator("ADMIN");
        RoleValidator user = new RoleValidator("USER");

        admin.executeMethod(service, "deleteUser");
        user.executeMethod(service, "deleteUser");
    }
}

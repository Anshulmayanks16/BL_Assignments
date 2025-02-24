import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation @Todo
@Retention(RetentionPolicy.RUNTIME) // Available at runtime for reflection
@Target(ElementType.METHOD) // Can be applied to methods only
@interface Todo {
    String task(); // Description of the task
    String assignedTo(); // Developer responsible
    String priority() default "MEDIUM"; // Default priority level
}

// Step 2: Apply @Todo annotation to multiple methods
class Project {
    
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob") // Uses default priority
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void enhanceUI() {
        System.out.println("Enhancing UI...");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection API
public class TodoProcessor {
    public static void main(String[] args) {
        Class<Project> obj = Project.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("------------------------------");
            }
        }
    }
}

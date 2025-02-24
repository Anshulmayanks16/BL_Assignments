import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation @ImportantMethod
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime for reflection
@Target(ElementType.METHOD) // Apply only to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Apply @ImportantMethod to methods
class Service {
    
    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod // Uses default level "HIGH"
    public void saveData() {
        System.out.println("Saving data...");
    }

    public void auxiliaryTask() {
        System.out.println("Performing auxiliary task...");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<Service> obj = Service.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("------------------------------");
            }
        }
    }
}

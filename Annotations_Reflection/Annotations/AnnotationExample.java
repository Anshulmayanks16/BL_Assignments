import java.lang.annotation.*;  
import java.lang.reflect.Method;  

// Step 1: Define a custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface TaskInfo {
    String priority() default "Medium"; // Default priority
    String assignedTo();
}

// Step 2: Apply the annotation to a method
class TaskManager {
    
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

// Step 3: Retrieve annotation details using Reflection
public class AnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}

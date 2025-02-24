import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the repeatable annotation @BugReport
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Allows multiple @BugReport annotations
@interface BugReport {
    String description();
    String reportedBy();
}

// Step 3: Apply @BugReport multiple times on a method
class Software {
    
    @BugReport(description = "Null pointer exception in edge case", reportedBy = "Alice")
    @BugReport(description = "Performance issue under high load", reportedBy = "Bob")
    public void process() {
        System.out.println("Processing software...");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection API
public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");

        // Check if @BugReport (or container annotation @BugReports) is present
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);

            // Print all bug reports
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
                System.out.println("Reported By: " + bug.reportedBy());
                System.out.println("--------------------------");
            }
        }
    }
}

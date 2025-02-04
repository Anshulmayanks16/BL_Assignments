class Employee {
    // Static variable shared across all employees
    private static String companyName = "Tech Solutions Pvt Ltd";
    private static int totalEmployees = 0; // Keeps track of total employees
    
    // Instance variables
    private String name;
    private final int id; // Final variable, cannot be changed once assigned
    private String designation;
    
    // Constructor using 'this' to resolve ambiguity
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id; // Final variable initialized
        this.designation = designation;
        totalEmployees++; // Increment employee count
    }
    
    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees at " + companyName + ": " + totalEmployees);
    }
    
    // Method to display employee details (using instanceof)
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("\n=== Employee Details ===");
            System.out.println("Company: " + companyName);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid Employee Object");
        }
    }
}

// Main class to test the implementation
public class EmployeeManagementApp {
    public static void main(String[] args) {
        // Creating employee objects
        Employee emp1 = new Employee("Alice Johnson", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob Smith", 102, "Project Manager");
        
        // Display total employees
        Employee.displayTotalEmployees();
        
        // Display employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        
        // Checking instanceof usage
        System.out.println("\nIs emp1 an instance of Employee? " + (emp1 instanceof Employee));
    }
}
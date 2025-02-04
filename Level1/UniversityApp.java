class Student {
    // Static variable shared across all students
    private static String universityName = "Global University";
    private static int totalStudents = 0; // Keeps track of total students enrolled
    
    // Instance variables
    private String name;
    private final int rollNumber; // Final variable, cannot be changed once assigned
    private char grade;
    
    // Constructor using 'this' to resolve ambiguity
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber; // Final variable initialized
        this.grade = grade;
        totalStudents++; // Increase total student count
    }
    
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled at " + universityName + ": " + totalStudents);
    }
    
    // Method to update grade
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " (Roll No: " + rollNumber + ")");
        } else {
            System.out.println("Invalid Student Object");
        }
    }
    
    // Method to display student details (using instanceof)
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("\n=== Student Details ===");
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid Student Object");
        }
    }
}

// Main class to test the implementation
public class UniversityApp {
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student("Alice Johnson", 101, 'A');
        Student student2 = new Student("Bob Smith", 102, 'B');
        
        // Display student details
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        
        // Display total students enrolled
        Student.displayTotalStudents();
        
        // Updating grade
        student2.updateGrade('A');

        // Display student details after grade update
        student2.displayStudentDetails();
        
        // Checking instanceof usage
        System.out.println("\nIs student1 an instance of Student? " + (student1 instanceof Student));
    }
}

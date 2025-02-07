// Superclass Person
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method to display basic details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Person {
    private String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);  // Calling superclass constructor
        this.subject = subject;
    }

    // Getter method
    public String getSubject() {
        return subject;
    }

    // Display role
    public void displayRole() {
        System.out.println("Role: Teacher");
        displayDetails();
        System.out.println("Subject: " + subject);
    }
}

// Subclass Student
class Student extends Person {
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        super(name, age);  // Calling superclass constructor
        this.grade = grade;
    }

    // Getter method
    public String getGrade() {
        return grade;
    }

    // Display role
    public void displayRole() {
        System.out.println("Role: Student");
        displayDetails();
        System.out.println("Grade: " + grade);
    }
}

// Subclass Staff
class Staff extends Person {
    private String department;

    // Constructor
    public Staff(String name, int age, String department) {
        super(name, age);  // Calling superclass constructor
        this.department = department;
    }

    // Getter method
    public String getDepartment() {
        return department;
    }

    // Display role
    public void displayRole() {
        System.out.println("Role: Staff");
        displayDetails();
        System.out.println("Department: " + department);
    }
}

// Main class to test
public class SchoolSystem {
    public static void main(String[] args) {
        // Creating a Teacher
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");

        // Creating a Student
        Student student = new Student("Bob Smith", 16, "10th Grade");

        // Creating a Staff member
        Staff staff = new Staff("Carol Williams", 42, "Administration");

        // Displaying roles and details
        System.out.println("Teacher Details:");
        teacher.displayRole();

        System.out.println("\nStudent Details:");
        student.displayRole();

        System.out.println("\nStaff Details:");
        staff.displayRole();
    }
}
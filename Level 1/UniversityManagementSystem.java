public class UniversityManagementSystem {

    // Student Class
    public static class Student {
        public int rollNumber;       // Public member
        protected String name;       // Protected member
        private double CGPA;         // Private member
        
        // Constructor
        public Student(int rollNumber, String name, double CGPA) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.CGPA = CGPA;
        }
        
        // Public methods to access and modify CGPA
        public double getCGPA() {
            return this.CGPA;
        }
        
        public void setCGPA(double CGPA) {
            if (CGPA >= 0 && CGPA <= 10) { // Validating CGPA range
                this.CGPA = CGPA;
            } else {
                System.out.println("Invalid CGPA. It must be between 0 and 10.");
            }
        }
        
        // Method to display student details
        public void displayStudentDetails() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("CGPA: " + CGPA);
        }
    }

    // PostgraduateStudent Class
    public static class PostgraduateStudent extends Student {
        private String thesisTopic;  // Additional member for postgraduate student
        
        // Constructor
        public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTopic) {
            super(rollNumber, name, CGPA);
            this.thesisTopic = thesisTopic;
        }
        
        // Method to display postgraduate student details
        @Override
        public void displayStudentDetails() {
            super.displayStudentDetails();  // Call the parent method
            System.out.println("Thesis Topic: " + thesisTopic);
        }
        
        // Method to access protected 'name' from superclass
        public void printName() {
            System.out.println("Name from PostgraduateStudent: " + name);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of Student
        Student student1 = new Student(101, "John Doe", 8.5);
        student1.displayStudentDetails();
        
        // Modify CGPA using public method
        student1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        
        // Create an instance of PostgraduateStudent
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Jane Smith", 9.8, "AI in Healthcare");
        pgStudent.displayStudentDetails();
        
        // Access protected 'name' from subclass
        pgStudent.printName();
    }
}
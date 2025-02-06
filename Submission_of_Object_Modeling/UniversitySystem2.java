import java.util.ArrayList;
import java.util.List;

public class UniversitySystem {

    // Course Class (Aggregation: A course has students and is taught by a professor)
    static class Course {
        private String courseName;
        private Professor professor;
        private List<Student> students;

        // Constructor
        public Course(String courseName) {
            this.courseName = courseName;
            this.students = new ArrayList<>();
        }

        // Assign a professor to the course
        public void assignProfessor(Professor professor) {
            this.professor = professor;
            professor.addCourse(this);
        }

        // Enroll a student in the course
        public void enrollStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
                student.addCourse(this);
            }
        }

        public String getCourseName() {
            return courseName;
        }

        public Professor getProfessor() {
            return professor;
        }

        public List<Student> getStudents() {
            return students;
        }

        // Display course details
        public void displayCourseInfo() {
            System.out.println("Course: " + courseName + " | Professor: " + (professor != null ? professor.getName() : "None"));
            System.out.println("Enrolled Students:");
            for (Student student : students) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }

    // Professor Class (Association: A professor teaches multiple courses)
    static class Professor {
        private String name;
        private List<Course> courses;

        // Constructor
        public Professor(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        // Add a course taught by the professor
        public void addCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
            }
        }

        public String getName() {
            return name;
        }

        // Display professor details
        public void displayProfessorInfo() {
            System.out.println("Professor: " + name);
            System.out.println("Courses taught:");
            for (Course course : courses) {
                System.out.println(course.getCourseName());
            }
            System.out.println();
        }
    }

    // Student Class (Association: A student can enroll in multiple courses)
    static class Student {
        private String name;
        private List<Course> courses;

        // Constructor
        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        // Enroll in a course
        public void enrollCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
                course.enrollStudent(this);
            }
        }

        public String getName() {
            return name;
        }

        // Display student details
        public void displayStudentInfo() {
            System.out.println("Student: " + name);
            System.out.println("Enrolled Courses:");
            for (Course course : courses) {
                System.out.println(course.getCourseName());
            }
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Create courses
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database Management");

        // Assign professors to courses
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Enroll students in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        // Display details
        professor1.displayProfessorInfo();
        professor2.displayProfessorInfo();

        student1.displayStudentInfo();
        student2.displayStudentInfo();

        course1.displayCourseInfo();
        course2.displayCourseInfo();
    }
}
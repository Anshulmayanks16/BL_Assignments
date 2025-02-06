import java.util.ArrayList;
import java.util.List;

public class SchoolSystem {

    // Course Class
    static class Course {
        private String courseName;
        private List<Student> enrolledStudents;

        // Constructor
        public Course(String courseName) {
            this.courseName = courseName;
            this.enrolledStudents = new ArrayList<>();
        }

        // Enroll a student in the course
        public void enrollStudent(Student student) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
                student.addCourse(this);  // Add this course to the student's list of courses
            }
        }

        // Display enrolled students
        public void displayEnrolledStudents() {
            System.out.println("Course: " + courseName);
            for (Student student : enrolledStudents) {
                System.out.println("Enrolled Student: " + student.getName());
            }
            System.out.println();
        }

        public String getCourseName() {
            return courseName;
        }
    }

    // Student Class
    static class Student {
        private String name;
        private List<Course> courses;

        // Constructor
        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        // Add course to student
        public void addCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
            }
        }

        // Display courses the student is enrolled in
        public void displayEnrolledCourses() {
            System.out.println("Student: " + name);
            for (Course course : courses) {
                System.out.println("Enrolled in: " + course.getCourseName());
            }
            System.out.println();
        }

        public String getName() {
            return name;
        }
    }

    // School Class (Aggregation)
    static class School {
        private String schoolName;
        private List<Student> students;

        // Constructor
        public School(String schoolName) {
            this.schoolName = schoolName;
            this.students = new ArrayList<>();
        }

        // Add student to school
        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        // Display all students in the school
        public void displayAllStudents() {
            System.out.println("School: " + schoolName);
            for (Student student : students) {
                student.displayEnrolledCourses();
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a school
        School school = new School("Greenwood High School");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Add students to school
        school.addStudent(student1);
        school.addStudent(student2);

        // Create courses
        Course course1 = new Course("Math");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);

        course2.enrollStudent(student1);

        course3.enrollStudent(student2);

        // Display courses each student is enrolled in
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();

        // Display all students enrolled in each course
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
        course3.displayEnrolledStudents();

        // Display all students in the school
        school.displayAllStudents();
    }
}
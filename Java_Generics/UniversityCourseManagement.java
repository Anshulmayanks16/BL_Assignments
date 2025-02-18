
import java.util.*;

// 1. Base Abstract Class for Course Types
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract void evaluate();

    public void displayCourseDetails() {
        System.out.println(" Course: " + courseName + " | Instructor: " + instructor);
    }
}

// 2. Specific Course Types
class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String courseName, String instructor, int examWeightage) {
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation: Exam-based with " + examWeightage + "% weightage.");
    }
}

class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
        super(courseName, instructor);
        this.assignmentCount = assignmentCount;
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation: Assignment-based with " + assignmentCount + " assignments.");
    }
}

class ResearchCourse extends CourseType {
    private String researchField;

    public ResearchCourse(String courseName, String instructor, String researchField) {
        super(courseName, instructor);
        this.researchField = researchField;
    }

    @Override
    public void evaluate() {
        System.out.println(" Evaluation: Research-based in the field of " + researchField + ".");
    }
}

// 3. Generic Course Manager
class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public T getCourse() {
        return course;
    }

    public void displayCourseInfo() {
        course.displayCourseDetails();
        course.evaluate();
    }
}

// 4. Course Catalog (Handles All Types of Courses)
class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    // Add any type of course to the catalog
    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
    }

    // Display all courses in the catalog
    public void displayAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            course.displayCourseInfo();
            System.out.println("---------------------------------------------------");
        }
    }
}

// 5. Main Class (Testing the System)
public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create specific course instances
        ExamCourse math101 = new ExamCourse("Math 101", "Dr. Smith", 70);
        AssignmentCourse cs201 = new AssignmentCourse("CS 201", "Prof. Johnson", 5);
        ResearchCourse bio301 = new ResearchCourse("Bio 301", "Dr. Williams", "Genetics");

        // Wrap courses in generic Course objects
        Course<ExamCourse> mathCourse = new Course<>(math101);
        Course<AssignmentCourse> csCourse = new Course<>(cs201);
        Course<ResearchCourse> bioCourse = new Course<>(bio301);

        // Create and manage the course catalog
        CourseCatalog catalog = new CourseCatalog();

        // Add courses to the catalog
        catalog.addCourse(mathCourse);
        catalog.addCourse(csCourse);
        catalog.addCourse(bioCourse);

        // Display all courses
        System.out.println(" University Course Catalog:");
        catalog.displayAllCourses();
    }
}
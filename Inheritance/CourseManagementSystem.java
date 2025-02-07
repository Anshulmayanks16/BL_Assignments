// Base class Course
class Course {
    private String courseName;
    private int duration; // duration in weeks

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getter methods
    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass OnlineCourse
class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    // Constructor
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);  // Calling superclass constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Getter methods
    public String getPlatform() {
        return platform;
    }

    public boolean getIsRecorded() {
        return isRecorded;
    }

    // Overriding displayCourseDetails to include platform and recording info
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();  // Display basic course details
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    // Constructor
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);  // Calling superclass constructor
        this.fee = fee;
        this.discount = discount;
    }

    // Getter methods
    public double getFee() {
        return fee;
    }

    public double getDiscount() {
        return discount;
    }

    // Method to calculate final price after discount
    public double getFinalPrice() {
        return fee - (fee * (discount / 100));
    }

    // Overriding displayCourseDetails to include fee and discount info
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();  // Display online course details
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + getFinalPrice());
    }
}

// Main class to test
public class CourseManagementSystem {
    public static void main(String[] args) {
        // Creating a general course
        Course course = new Course("Introduction to Programming", 8);

        // Creating an online course
        OnlineCourse onlineCourse = new OnlineCourse("Web Development", 10, "Udemy", true);

        // Creating a paid online course
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Advanced Java", 12, "Coursera", true, 200.0, 15.0);

        // Displaying course details
        System.out.println("General Course Details:");
        course.displayCourseDetails();

        System.out.println("\nOnline Course Details:");
        onlineCourse.displayCourseDetails();

        System.out.println("\nPaid Online Course Details:");
        paidOnlineCourse.displayCourseDetails();
    }
}
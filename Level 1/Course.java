class Course {
    private char[] courseName;
    private int duration; // in weeks
    private double fee;
    private static char[] instituteName = {'D', 'e', 'f', 'a', 'u', 'l', 't', ' ', 'I', 'n', 's', 't', 'i', 't', 'u', 't', 'e'};

    // Constructor
    public Course(char[] courseName, int duration, double fee) {
        this.courseName = copyCharArray(courseName);
        this.duration = duration;
        this.fee = fee;
    }

    // Copy character array manually
    private char[] copyCharArray(char[] source) {
        if (source == null) return new char[0];
        char[] copy = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.print("Course Name: ");
        printCharArray(courseName);
        System.out.print(" | Duration: " + duration + " weeks");
        System.out.print(" | Fee: " + fee);
        System.out.print(" | Institute: ");
        printCharArray(instituteName);
        System.out.println();
    }

    // Static method to update institute name
    public static void updateInstituteName(char[] newName) {
        instituteName = new char[newName.length];
        for (int i = 0; i < newName.length; i++) {
            instituteName[i] = newName[i];
        }
    }

    // Print character array manually
    private void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        char[] course1 = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        char[] course2 = {'D', 'a', 't', 'a', ' ', 'S', 'c', 'i', 'e', 'n', 'c', 'e'};
        
        Course javaCourse = new Course(course1, 12, 499.99);
        Course dataScienceCourse = new Course(course2, 16, 699.99);
        
        javaCourse.displayCourseDetails();
        dataScienceCourse.displayCourseDetails();
        
        char[] newInstitute = {'T', 'e', 'c', 'h', ' ', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        Course.updateInstituteName(newInstitute);
        
        javaCourse.displayCourseDetails();
        dataScienceCourse.displayCourseDetails();
    }
}

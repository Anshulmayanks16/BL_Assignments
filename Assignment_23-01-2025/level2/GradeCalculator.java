import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for three subjects
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();

        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();

        // Compute total and percentage
        int totalMarks = physics + chemistry + maths;
        double percentage = (totalMarks / 3.0);

        // Determine grade and remarks
        String grade;
        String remarks;

        if (percentage >= 90) {
            grade = "A+";
            remarks = "Excellent";
        } else if (percentage >= 80) {
            grade = "A";
            remarks = "Very Good";
        } else if (percentage >= 70) {
            grade = "B+";
            remarks = "Good";
        } else if (percentage >= 60) {
            grade = "B";
            remarks = "Satisfactory";
        } else if (percentage >= 50) {
            grade = "C";
            remarks = "Needs Improvement";
        } else {
            grade = "F";
            remarks = "Fail";
        }

        // Output the results
        System.out.println("\n=== Results ===");
        System.out.println("Physics Marks: " + physics);
        System.out.println("Chemistry Marks: " + chemistry);
        System.out.println("Maths Marks: " + maths);
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
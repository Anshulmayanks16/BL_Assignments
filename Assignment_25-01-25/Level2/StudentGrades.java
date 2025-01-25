import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create arrays to store marks, percentages, and grades
        double[][] marks = new double[numStudents][3];  // marks[i][0] = Physics, marks[i][1] = Chemistry, marks[i][2] = Maths
        double[] percentages = new double[numStudents];  // Store percentage of each student
        String[] grades = new String[numStudents];  // Store grade for each student

        // Take input for marks for each student in Physics, Chemistry, and Maths
        for (int i = 0; i < numStudents; i++) {
            // Ensure valid input for marks
            do {
                System.out.print("Enter the marks for Physics (0-100) for student " + (i + 1) + ": ");
                marks[i][0] = scanner.nextDouble();
                if (marks[i][0] < 0 || marks[i][0] > 100) {
                    System.out.println("Please enter valid marks between 0 and 100.");
                }
            } while (marks[i][0] < 0 || marks[i][0] > 100);

            do {
                System.out.print("Enter the marks for Chemistry (0-100) for student " + (i + 1) + ": ");
                marks[i][1] = scanner.nextDouble();
                if (marks[i][1] < 0 || marks[i][1] > 100) {
                    System.out.println("Please enter valid marks between 0 and 100.");
                }
            } while (marks[i][1] < 0 || marks[i][1] > 100);

            do {
                System.out.print("Enter the marks for Maths (0-100) for student " + (i + 1) + ": ");
                marks[i][2] = scanner.nextDouble();
                if (marks[i][2] < 0 || marks[i][2] > 100) {
                    System.out.println("Please enter valid marks between 0 and 100.");
                }
            } while (marks[i][2] < 0 || marks[i][2] > 100);

            // Calculate the percentage
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;

            // Determine the grade based on the percentage
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 60) {
                grades[i] = "B";
            } else if (percentages[i] >= 40) {
                grades[i] = "C";
            } else {
                grades[i] = "D";
            }
        }

        // Display marks, percentages, and grades for each student
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class StudentVoteChecker {
    
    // Method to check if the student can vote based on age
    public boolean canStudentVote(int age) {
        // Validate age for negative input
        if (age < 0) {
            return false; // Negative age is not valid
        }
        
        // Check if age is 18 or above to vote
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the StudentVoteChecker class
        StudentVoteChecker checker = new StudentVoteChecker();
        
        // Create an array to store the age of 10 students
        int[] studentAges = new int[10];
        
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Loop through to get the age of all 10 students
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
            
            // Check if the student can vote
            if (checker.canStudentVote(studentAges[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
        
        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        // Define an array to store ages of 10 students
        int[] studentAges = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Taking input for the ages of all 10 students
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        // Checking voting eligibility for each student
        System.out.println("\nVoting eligibility results:");
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];

            if (age < 0) {
                System.out.println("Student " + (i + 1) + " has an invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        // Closing the scanner
        scanner.close();
    }
}
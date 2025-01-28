import java.util.Random;

public class StudentScoreCard {

    // Method to generate random 2-digit scores for Physics, Chemistry, and Maths
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // 2D array for PCM scores

        for (int i = 0; i < numStudents; i++) {
            // Generate random 2-digit scores for each subject (between 50 and 99)
            scores[i][0] = rand.nextInt(50) + 50; // Physics
            scores[i][1] = rand.nextInt(50) + 50; // Chemistry
            scores[i][2] = rand.nextInt(50) + 50; // Math
        }
        return scores;
    }

    // Method to calculate the total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; // 2D array: [0] - Total, [1] - Average, [2] - Percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Rounding off values to 2 decimal places
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to display the scorecard of all students in tabular format
    public static void displayScoreCard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t", i + 1);
            // Display PCM scores for the student
            System.out.printf("%d\t\t%d\t\t%d\t\t", scores[i][0], scores[i][1], scores[i][2]);
            // Display total, average, and percentage
            System.out.printf("%d\t\t%.2f\t\t%.2f\n", (int) results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        // Taking the number of students as input
        int numStudents = 5;  // Example: for 5 students, modify this if needed

        // Generate random scores for students
        int[][] scores = generateScores(numStudents);

        // Calculate total, average, and percentage
        double[][] results = calculateResults(scores);

        // Display the scorecard
        displayScoreCard(scores, results);
    }
}
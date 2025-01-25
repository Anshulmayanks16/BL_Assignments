import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store age and height of the 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] friends = {"Amar", "Akbar", "Anthony"};

        // Input age and height for each friend
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height of " + friends[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Find the youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        // Find the tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the youngest and tallest friends
        System.out.println("\nThe youngest friend is: " + friends[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("The tallest friend is: " + friends[tallestIndex] + " (Height: " + heights[tallestIndex] + " meters)");

        scanner.close();
    }
}
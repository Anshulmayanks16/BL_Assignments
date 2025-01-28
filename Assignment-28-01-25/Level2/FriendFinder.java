import java.util.Scanner;

public class FriendFinder {

    // Method to find the youngest friend
    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        String youngestFriend = "Amar";
        
        // Check the youngest friend based on age
        if (ages[1] < minAge) {
            minAge = ages[1];
            youngestFriend = "Akbar";
        }
        if (ages[2] < minAge) {
            youngestFriend = "Anthony";
        }
        
        return youngestFriend;
    }

    // Method to find the tallest friend
    public static String findTallest(double[] heights) {
        double maxHeight = heights[0];
        String tallestFriend = "Amar";
        
        // Check the tallest friend based on height
        if (heights[1] > maxHeight) {
            maxHeight = heights[1];
            tallestFriend = "Akbar";
        }
        if (heights[2] > maxHeight) {
            tallestFriend = "Anthony";
        }
        
        return tallestFriend;
    }

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Create arrays to store age and height for the 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Take user input for ages and heights
        System.out.println("Enter the details for the 3 friends:");

        // Amar's details
        System.out.print("Enter Amar's age: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        heights[0] = scanner.nextDouble();
        
        // Akbar's details
        System.out.print("Enter Akbar's age: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        heights[1] = scanner.nextDouble();
        
        // Anthony's details
        System.out.print("Enter Anthony's age: ");
        ages[2] = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        heights[2] = scanner.nextDouble();
        
        // Find the youngest friend
        String youngest = findYoungest(ages);
        System.out.println("The youngest friend is: " + youngest);
        
        // Find the tallest friend
        String tallest = findTallest(heights);
        System.out.println("The tallest friend is: " + tallest);
        
        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
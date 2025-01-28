import java.util.Random;

public class FootballTeamHeight {

    // Method to generate an array of random heights for 11 players
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        Random rand = new Random();

        // Generate random heights between 150 and 250 cm
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150;  // Random number between 150 and 250
        }

        return heights;
    }

    // Method to find the sum of all elements in the array
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // Method to find the mean height of the players
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find the shortest height among the players
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }

    // Method to find the tallest height among the players
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        int size = 11;  // The number of players in the team
        int[] heights = generateRandomHeights(size);

        // Display the generated heights
        System.out.println("Heights of players in the football team (in cms):");
        for (int height : heights) {
            System.out.println(height);
        }

        // Find and display the sum, mean, shortest, and tallest height
        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("\nSum of heights: " + sum);
        System.out.println("Mean height: " + mean);
        System.out.println("Shortest height: " + shortest);
        System.out.println("Tallest height: " + tallest);
    }
}
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Think of a number between 1 and 100, and I'll try to guess it!");
        System.out.println("Respond with 'higher', 'lower', or 'correct'.");

        int lowerBound = 1;
        int upperBound = 100;
        int guess;
        String response;

        while (true) {
            // Generate a guess within the current range
            guess = generateGuess(lowerBound, upperBound, random);
            System.out.println("Is your number " + guess + "?");

            // Get user feedback
            response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("correct")) {
                System.out.println("Yay! I guessed your number.");
                break;
            } else if (response.equals("higher")) {
                lowerBound = guess + 1; // Adjust lower bound
            } else if (response.equals("lower")) {
                upperBound = guess - 1; // Adjust upper bound
            } else {
                System.out.println("Invalid response. Please reply with 'higher', 'lower', or 'correct'.");
            }

            if (lowerBound > upperBound) {
                System.out.println("Hmm, something went wrong. Did you change your number?");
                break;
            }
        }

        scanner.close();
    }

    // Method to generate a guess within a range
    public static int generateGuess(int lowerBound, int upperBound, Random random) {
        return lowerBound + random.nextInt(upperBound - lowerBound + 1);
    }
}
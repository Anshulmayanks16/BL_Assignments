import java.util.Random;

public class RandomValues {

    // Method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        Random rand = new Random();

        // Generate random 4-digit numbers
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = rand.nextInt(9000) + 1000;  // Generates numbers between 1000 and 9999
        }

        return randomNumbers;
    }

    // Method to find average, minimum, and maximum values of an array
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        // Loop through the array to calculate sum, min, and max
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = sum / numbers.length;

        return new double[] {average, min, max};
    }

    public static void main(String[] args) {
        int size = 5;  // We need 5 random values
        int[] randomNumbers = generate4DigitRandomArray(size);

        // Display the generated random numbers
        System.out.println("Generated 4-digit random numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }

        // Find average, min, and max values
        double[] results = findAverageMinMax(randomNumbers);

        // Display the results
        System.out.println("\nAverage value: " + results[0]);
        System.out.println("Minimum value: " + results[1]);
        System.out.println("Maximum value: " + results[2]);
    }
}

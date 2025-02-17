import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // Different dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int target = data[random.nextInt(size)]; // Select a random target
            
            // Measure Linear Search Time
            long startTime = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;
            
            // Sort the array for Binary Search
            Arrays.sort(data);
            
            // Measure Binary Search Time
            startTime = System.nanoTime();
            int binaryResult = binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;
            
            // Output Results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime / 1e6) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1e6) + " ms");
            System.out.println("-------------------------");
        }
    }
    
    // Generate a random array of given size
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }
    
    // Linear Search: O(N)
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    
    // Binary Search: O(log N)
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
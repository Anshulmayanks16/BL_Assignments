import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 100_000, 1_000_000};
        Random random = new Random();

        for (int n : datasetSizes) {
            System.out.println("Dataset Size: " + n);

            // Generate random dataset
            int[] array = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                int value = random.nextInt(n * 10); // Ensure some uniqueness
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }

            int target = array[random.nextInt(n)]; // Pick a random element to search

            // Linear Search (Array)
            long startTime = System.nanoTime();
            boolean arrayFound = linearSearch(array, target);
            long arrayTime = System.nanoTime() - startTime;
            System.out.println("Array Search Time: " + (arrayTime / 1e6) + " ms");

            // HashSet Search (O(1))
            startTime = System.nanoTime();
            boolean hashSetFound = hashSet.contains(target);
            long hashSetTime = System.nanoTime() - startTime;
            System.out.println("HashSet Search Time: " + (hashSetTime / 1e6) + " ms");

            // TreeSet Search (O(log N))
            startTime = System.nanoTime();
            boolean treeSetFound = treeSet.contains(target);
            long treeSetTime = System.nanoTime() - startTime;
            System.out.println("TreeSet Search Time: " + (treeSetTime / 1e6) + " ms");

            System.out.println("-------------------------");
        }
    }

    // Linear Search for Array (O(N))
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
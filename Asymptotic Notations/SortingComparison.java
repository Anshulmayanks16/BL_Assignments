import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // Dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            
            System.out.println("Dataset Size: " + size);

            // Bubble Sort (O(N²))
            int[] bubbleArray = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long bubbleTime = System.nanoTime() - startTime;
            if (size <= 10000) { // Avoid running Bubble Sort for large N
                System.out.println("Bubble Sort Time: " + (bubbleTime / 1e6) + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Merge Sort (O(N log N))
            int[] mergeArray = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long mergeTime = System.nanoTime() - startTime;
            System.out.println("Merge Sort Time: " + (mergeTime / 1e6) + " ms");

            // Quick Sort (O(N log N))
            int[] quickArray = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            long quickTime = System.nanoTime() - startTime;
            System.out.println("Quick Sort Time: " + (quickTime / 1e6) + " ms");

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

    // Bubble Sort: O(N²)
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }

    // Merge Sort: O(N log N)
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < n1) arr[k++] = leftArray[i++];
        while (j < n2) arr[k++] = rightArray[j++];
    }

    // Quick Sort: O(N log N)
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot: last element
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
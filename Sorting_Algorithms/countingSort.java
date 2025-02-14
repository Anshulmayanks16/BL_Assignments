public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count occurrences
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void printArray(int[] array) {
        for (int age : array) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 14, 10, 18, 11, 16, 12, 17, 13, 15};

        System.out.print("Original Student Ages: ");
        printArray(studentAges);

        countingSort(studentAges, 10, 18);

        System.out.print("Sorted Student Ages: ");
        printArray(studentAges);
    }
}
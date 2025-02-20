import java.util.*;

public class ListRotator {
    // Rotate the list by k positions
    public static void rotateList(List<Integer> list, int k) {
        int n = list.size();
        k = k % n; // Handle cases where k > n

        // Reverse the three parts to achieve rotation
        Collections.reverse(list.subList(0, k));
        Collections.reverse(list.subList(k, n));
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2; // Number of positions to rotate

        System.out.println("Original List: " + numbers);
        rotateList(numbers, k);
        System.out.println("Rotated List: " + numbers);
    }
}
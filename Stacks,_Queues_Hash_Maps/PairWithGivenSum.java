import java.util.*;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true; // Found a pair
            }
            seen.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 2, 9, 5};
        int target = 10;

        System.out.println(hasPairWithSum(arr, target) ? "Pair exists" : "No pair found");
    }
}
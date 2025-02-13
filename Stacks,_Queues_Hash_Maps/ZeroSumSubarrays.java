import java.util.*;

class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // Stores sum → indices
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;

        // Initialize map with sum 0 at index -1 (to handle subarrays starting from 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum exists, all subarrays from stored indices to current index have sum zero
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store start & end indices
                }
            }

            // Store current sum in map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        for (List<Integer> subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray.get(0) + " to " + subarray.get(1));
        }
    }
}
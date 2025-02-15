import java.util.Arrays;

public class SearchChallenge {
    
    // Linear Search: Find the first missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each number at its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1; // If all numbers are present, return the next positive integer
    }

    // Binary Search: Find the index of a target number
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // Sort the array before binary search
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Find first missing positive
        int missing = firstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missing);

        // Find target index using Binary Search
        int index = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}

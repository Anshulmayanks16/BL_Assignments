import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Initialize a HashSet
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert to List
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort the List
        Collections.sort(sortedList);

        // Print the result
        System.out.println("Sorted List: " + sortedList);
    }
}

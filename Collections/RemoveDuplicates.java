import java.util.*;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        
        for (T item : list) {
            if (seen.add(item)) { // Adds only if it's not already present
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        
        System.out.println("Original List: " + numbers);
        System.out.println("List After Removing Duplicates: " + uniqueNumbers);
    }
}

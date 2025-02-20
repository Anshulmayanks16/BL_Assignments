import java.util.Set;
import java.util.HashSet;

public class SubsetCheck {
    public static void main(String[] args) {
        // Initialize sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Print result
        System.out.println("Is set1 a subset of set2? " + isSubset);
    }
}

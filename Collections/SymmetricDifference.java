import java.util.Set;
import java.util.HashSet;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Initialize sets
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Compute Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Compute Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Compute Symmetric Difference: (Union - Intersection)
        Set<Integer> symmetricDifference = new HashSet<>(union);
        symmetricDifference.removeAll(intersection);

        // Print result
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}

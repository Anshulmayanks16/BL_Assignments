import java.util.Set;
import java.util.HashSet;

public class SetOperations {
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
        Set<Integer> union = new HashSet<>(set1); // Copy set1
        union.addAll(set2); // Add all elements of set2

        // Compute Intersection
        Set<Integer> intersection = new HashSet<>(set1); // Copy set1
        intersection.retainAll(set2); // Retain only common elements

        // Print results
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}

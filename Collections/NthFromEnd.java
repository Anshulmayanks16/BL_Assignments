import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }

        var first = list.listIterator(); // Fast pointer
        var second = list.listIterator(); // Slow pointer

        // Move `first` ahead by `n` steps
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new NoSuchElementException("List is shorter than " + n);
            }
            first.next();
        }

        // Move both pointers until `first` reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // `second` now points to the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2; // Find the 2nd element from the end
        System.out.println("Nth Element from End: " + findNthFromEnd(list, n)); // Output: D
    }
}

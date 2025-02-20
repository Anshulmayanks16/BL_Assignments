import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator (Higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity) // Descending order
        );

        // Add patients to the queue
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        // Process patients in order of severity
        System.out.println("Order of Treatment:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

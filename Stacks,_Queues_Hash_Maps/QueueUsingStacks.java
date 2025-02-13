import java.util.Stack;

// Class to implement Queue using two stacks
class QueueUsingStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Enqueue operation: O(1)
    public void enqueue(int x) {
        enqueueStack.push(x);
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation: Amortized O(1), worst-case O(n)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        int removed = dequeueStack.pop();
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek front element: O(1) (amortized)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        int front = dequeueStack.peek();
        System.out.println("Front element: " + front);
        return front;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}

// Main class to test the QueueUsingStacks implementation
public class Main {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue elements
        queue.dequeue(); // Expected output: Dequeued: 1
        queue.peek();    // Expected output: Front element: 2
        queue.dequeue(); // Expected output: Dequeued: 2

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Expected: false

        queue.dequeue(); // Expected output: Dequeued: 3
        System.out.println("Is queue empty? " + queue.isEmpty()); // Expected: true

        // Attempting to dequeue from an empty queue
        queue.dequeue(); // Expected output: Queue is empty. Cannot dequeue.
    }
}
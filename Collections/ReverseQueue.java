import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Add elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        
        // Reverse the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue all elements into a stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Push them back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}

import java.util.*;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes and returns the top element
    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        // Move n-1 elements from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Last element of q1 is the top of the stack
        int topElement = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Get the top element without removing it
    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        // Move n-1 elements to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Peek the last element
        int topElement = q1.peek();
        q2.add(q1.remove()); // Move back to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Pop: " + stack.pop()); // 2
        System.out.println("Is Empty: " + stack.isEmpty()); // false
    }
}

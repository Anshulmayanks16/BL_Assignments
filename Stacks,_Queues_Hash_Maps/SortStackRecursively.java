import java.util.Stack;

class SortStackRecursively {
    
    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();  // Pop the top element
            sortStack(stack);       // Sort the remaining stack
            insertInSortedOrder(stack, top); // Insert popped element correctly
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element); // Base case: insert when stack is empty or element is in order
        } else {
            int top = stack.pop();  // Pop top element
            insertInSortedOrder(stack, element); // Recursive call
            stack.push(top); // Push the element back after placing element in order
        }
    }

    // Driver code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        
        System.out.println("Original Stack: " + stack);
        
        sortStack(stack);
        
        System.out.println("Sorted Stack: " + stack);
    }
}
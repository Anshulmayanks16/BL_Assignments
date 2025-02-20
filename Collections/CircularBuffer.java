import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        front = 0;
        rear = 0;
        count = 0;
    }

    // Insert an element into the buffer (overwrites if full)
    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size; // Move rear forward circularly
        
        if (count < size) {
            count++;
        } else { // Buffer is full, move front forward to overwrite oldest element
            front = (front + 1) % size;
        }
    }

    // Get the buffer contents
    public int[] getBufferContents() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = buffer[(front + i) % size];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBufferContents())); // [1, 2, 3]

        cb.enqueue(4); // Overwrites oldest element
        System.out.println("Buffer: " + Arrays.toString(cb.getBufferContents())); // [2, 3, 4]
    }
}

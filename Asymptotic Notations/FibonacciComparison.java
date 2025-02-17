public class FibonacciComparison {

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        for (int n : testCases) {
            System.out.println("Fibonacci for N = " + n);

            // Recursive Fibonacci (O(2ⁿ))
            long startTime = System.nanoTime();
            long fibRecursive = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            if (n <= 30) { // Avoid running recursive for large N
                System.out.println("Recursive Result: " + fibRecursive);
                System.out.println("Recursive Time: " + (recursiveTime / 1e6) + " ms");
            } else {
                System.out.println("Recursive Time: Unfeasible (>1hr)");
            }

            // Iterative Fibonacci (O(N))
            startTime = System.nanoTime();
            long fibIterative = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            System.out.println("Iterative Result: " + fibIterative);
            System.out.println("Iterative Time: " + (iterativeTime / 1e6) + " ms");
            System.out.println("-------------------------");
        }
    }

    // Recursive Fibonacci (O(2ⁿ))
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
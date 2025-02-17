public class StringConcatenationComparison {
    
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // Different dataset sizes

        for (int size : sizes) {
            System.out.println("Operations Count: " + size);

            // String Concatenation (O(N²))
            long startTime = System.nanoTime();
            stringConcatenation(size);
            long stringTime = System.nanoTime() - startTime;
            if (size <= 10000) { // Avoid running String concatenation for large N
                System.out.println("String Time: " + (stringTime / 1e6) + " ms");
            } else {
                System.out.println("String Time: Unusable");
            }

            // StringBuilder Concatenation (O(N))
            startTime = System.nanoTime();
            stringBuilderConcatenation(size);
            long stringBuilderTime = System.nanoTime() - startTime;
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1e6) + " ms");

            // StringBuffer Concatenation (O(N))
            startTime = System.nanoTime();
            stringBufferConcatenation(size);
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1e6) + " ms");

            System.out.println("-------------------------");
        }
    }

    // String Concatenation (O(N²))
    private static void stringConcatenation(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // Creates new object every time
        }
    }

    // StringBuilder Concatenation (O(N))
    private static void stringBuilderConcatenation(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    // StringBuffer Concatenation (O(N))
    private static void stringBufferConcatenation(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }
}

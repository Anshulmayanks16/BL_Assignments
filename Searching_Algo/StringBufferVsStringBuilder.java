public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";

        // Measure time for StringBuffer
        long startTime1 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTime1 = System.nanoTime();
        long durationStringBuffer = endTime1 - startTime1;

        // Measure time for StringBuilder
        long startTime2 = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append(text);
        }
        long endTime2 = System.nanoTime();
        long durationStringBuilder = endTime2 - startTime2;

        // Print results
        System.out.println("Time taken by StringBuffer: " + durationStringBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + durationStringBuilder / 1_000_000 + " ms");
    }
}
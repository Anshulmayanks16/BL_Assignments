import java.lang.reflect.Method;

class SampleMethods {
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println(methodName + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            throw new RuntimeException("Error measuring execution time", e);
        }
    }

    public static void main(String[] args) {
        SampleMethods sample = new SampleMethods();
        measureExecutionTime(sample, "fastMethod");
        measureExecutionTime(sample, "slowMethod");
    }
}


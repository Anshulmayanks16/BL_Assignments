import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvoker {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);

            int result = (int) method.invoke(calculator, 5, 4);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            throw new RuntimeException("Reflection error", e);
        }
    }
}

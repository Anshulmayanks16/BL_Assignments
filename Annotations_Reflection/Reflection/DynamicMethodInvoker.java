import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();
        System.out.print("Enter two numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();

        try {
            MathOperations obj = new MathOperations();
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(obj, num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid method name or error invoking method.");
        }
    }
}

public class ExceptionPropagationExample {
    
    // Method that throws ArithmeticException
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }
    
    // Method that calls method1()
    public static void method2() {
        method1();
    }
    
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
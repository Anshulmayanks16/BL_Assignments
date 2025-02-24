import java.util.ArrayList;

public class SuppressWarningExample {
    
    @SuppressWarnings("unchecked") // Suppressing unchecked warning
    public static void main(String[] args) {
        // Using raw type (Not recommended)
        ArrayList rawList = new ArrayList(); 
        
        rawList.add("Hello");
        rawList.add(42); // No type safety

        // Proper way using generics (Best practice)
        ArrayList<String> typedList = new ArrayList<>();
        typedList.add("Hello");
        // typedList.add(42); // This would cause a compile-time error
        
        // Retrieving values safely
        String firstElement = typedList.get(0);
        System.out.println("First Element: " + firstElement);
    }
}

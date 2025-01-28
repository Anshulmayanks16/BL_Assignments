public class NumberChecker {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;  // Prime numbers are greater than 1
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;  // If divisible by any number other than 1 and itself, it's not prime
            }
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        
        // Sum of digits of the square of the number
        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }
        
        // Check if the sum of digits equals the original number
        return sum == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpy(int number) {
        int sum = 0, product = 1;
        
        // Sum and product of digits of the number
        int temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        // Check if sum equals product
        return sum == product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        
        // Check if the square ends with the number itself
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzz(int number) {
        return (number % 7 == 0 || String.valueOf(number).endsWith("7"));
    }

    public static void main(String[] args) {
        int number = 25; // You can change this number for testing
        
        // Check if the number is prime
        boolean prime = isPrime(number);
        System.out.println("Is " + number + " a Prime Number? " + prime);
        
        // Check if the number is neon
        boolean neon = isNeon(number);
        System.out.println("Is " + number + " a Neon Number? " + neon);
        
        // Check if the number is spy
        boolean spy = isSpy(number);
        System.out.println("Is " + number + " a Spy Number? " + spy);
        
        // Check if the number is automorphic
        boolean automorphic = isAutomorphic(number);
        System.out.println("Is " + number + " an Automorphic Number? " + automorphic);
        
        // Check if the number is buzz
        boolean buzz = isBuzz(number);
        System.out.println("Is " + number + " a Buzz Number? " + buzz);
    }
}
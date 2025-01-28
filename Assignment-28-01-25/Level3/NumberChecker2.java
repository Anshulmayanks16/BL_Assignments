import java.util.Arrays;

public class NumberChecker {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // Method to store the digits of the number in a digits array
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        return digits;
    }

    // Method to find the sum of the digits in the number
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // Method to find the sum of the squares of the digits in the number
    public static double sumOfSquaresOfDigits(int[] digits) {
        double sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }

    // Method to check if a number is a Harshad number
    public static boolean isHarshadNumber(int number) {
        int[] digits = storeDigits(number);
        int sumOfDigits = sumOfDigits(digits);
        return number % sumOfDigits == 0;
    }

    // Method to find the frequency of each digit in the number
    public static int[][] digitFrequency(int[] digits) {
        int[][] frequency = new int[10][2]; // Array to store frequency of digits 0 to 9
        
        // Initialize the first column (digit) to 0-9
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        
        // Count the frequency of each digit
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        
        // Remove entries with zero frequency for cleaner output
        int nonZeroCount = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                nonZeroCount++;
            }
        }
        
        int[][] result = new int[nonZeroCount][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                result[index++] = frequency[i];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int number = 21;  // You can change this to test with other numbers
        
        // Count the number of digits
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        
        // Store digits in an array
        int[] digits = storeDigits(number);
        System.out.println("Digits: " + Arrays.toString(digits));
        
        // Find the sum of digits
        int sumDigits = sumOfDigits(digits);
        System.out.println("Sum of digits: " + sumDigits);
        
        // Find the sum of squares of digits
        double sumSquaresDigits = sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumSquaresDigits);
        
        // Check if the number is a Harshad number
        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad Number: " + isHarshad);
        
        // Find the frequency of each digit
        int[][] frequencies = digitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] frequency : frequencies) {
            System.out.println("Digit: " + frequency[0] + " Frequency: " + frequency[1]);
        }
    }
}
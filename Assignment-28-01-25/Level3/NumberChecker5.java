import java.math.BigInteger;

public class NumberChecker {

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int[] temp = new int[number];
        int count = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                temp[count++] = i;
            }
        }
        int[] factors = new int[count];
        System.arraycopy(temp, 0, factors, 0, count);
        return factors;
    }

    // Method to find the greatest factor of a number using the factors array
    public static int findGreatestFactor(int[] factors) {
        int greatestFactor = factors[0];
        for (int factor : factors) {
            if (factor > greatestFactor) {
                greatestFactor = factor;
            }
        }
        return greatestFactor;
    }

    // Method to find the sum of the factors using the factors array
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors using the factors array
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the product of cube of the factors using the factors array
    public static double productOfCubesOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum < number;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int tempNumber = number;

        while (tempNumber != 0) {
            int digit = tempNumber % 10;
            sum += factorial(digit);
            tempNumber /= 10;
        }

        return sum == number;
    }

    // Helper method to calculate factorial of a number
    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 145;  // You can change this number for testing
        
        // Find factors of the number
        int[] factors = findFactors(number);
        System.out.println("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Find greatest factor
        int greatestFactor = findGreatestFactor(factors);
        System.out.println("Greatest factor of " + number + ": " + greatestFactor);

        // Find sum of factors
        int sumFactors = sumOfFactors(factors);
        System.out.println("Sum of factors of " + number + ": " + sumFactors);

        // Find product of factors
        int productFactors = productOfFactors(factors);
        System.out.println("Product of factors of " + number + ": " + productFactors);

        // Find product of cube of factors
        double productCubes = productOfCubesOfFactors(factors);
        System.out.println("Product of cubes of factors of " + number + ": " + productCubes);

        // Check if number is a perfect number
        boolean perfect = isPerfectNumber(number);
        System.out.println("Is " + number + " a perfect number? " + perfect);

        // Check if number is an abundant number
        boolean abundant = isAbundantNumber(number);
        System.out.println("Is " + number + " an abundant number? " + abundant);

        // Check if number is a deficient number
        boolean deficient = isDeficientNumber(number);
        System.out.println("Is " + number + " a deficient number? " + deficient);

        // Check if number is a strong number
        boolean strong = isStrongNumber(number);
        System.out.println("Is " + number + " a strong number? " + strong);
    }
}

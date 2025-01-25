import java.util.Scanner;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define the array to store digits, with a max size of 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits from the number and store them in the array
        while (number != 0) {
            digits[index] = number % 10;  // Get the last digit
            number /= 10;  // Remove the last digit
            index++;
            
            // Break the loop if the array is full
            if (index == maxDigit) {
                break;
            }
        }

        // Variables to store largest and second largest digits
        int largest = -1;
        int secondLargest = -1;

        // Find the largest and second largest digits in the array
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display the largest and second largest digits
        if (largest != -1 && secondLargest != -1) {
            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("The number does not have enough distinct digits.");
        }

        scanner.close();
    }
}
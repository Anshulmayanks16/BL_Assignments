import java.util.Scanner;

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check divisibility by 5
        if (number % 5 == 0) {
            System.out.println("Is the number " + number + " divisible by 5? Yes");
        } else {
            System.out.println("Is the number " + number + " divisible by 5? No");
        }

        scanner.close();
    }
}
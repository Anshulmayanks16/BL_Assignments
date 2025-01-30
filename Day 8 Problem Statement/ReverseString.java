import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        // Reverse the string manually
        char[] reversed = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reversed[i] = input.charAt(input.length() - 1 - i);
        }

        System.out.print("Reversed string: ");
        for (char c : reversed) {
            System.out.print(c);
        }
    }
}

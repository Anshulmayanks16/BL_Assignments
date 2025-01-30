public class ToggleCase {

    public static String toggleCase(String input) {
        String result = "";
        
        // Iterate through each character of the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // Check if the character is an uppercase letter
            if (currentChar >= 'A' && currentChar <= 'Z') {
                // Convert it to lowercase by adding 32 to its ASCII value
                result += (char) (currentChar + 32);
            }
            // Check if the character is a lowercase letter
            else if (currentChar >= 'a' && currentChar <= 'z') {
                // Convert it to uppercase by subtracting 32 from its ASCII value
                result += (char) (currentChar - 32);
            }
            else {
                // If it's not a letter, just append the character as is
                result += currentChar;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String input = "Java ProGram 123!";
        String toggled = toggleCase(input);
        System.out.println("Original: " + input);
        System.out.println("Toggled: " + toggled);
    }
}

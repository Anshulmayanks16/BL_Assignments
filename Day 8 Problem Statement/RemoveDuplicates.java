public class RemoveDuplicates {

    public static String removeDuplicates(String input) {
        // Result string to store characters without duplicates
        String result = "";
        
        // Iterate through each character of the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // Check if the current character is already in the result string
            boolean isDuplicate = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }
            
            // If it's not a duplicate, add it to the result string
            if (!isDuplicate) {
                result += currentChar;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        String output = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + output);
    }
}

public class RemoveSpecificCharacter {

    public static String removeCharacter(String input, char charToRemove) {
        String result = "";
        
        // Loop through the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // If the current character is not the one to remove, append it to the result
            if (currentChar != charToRemove) {
                result += currentChar;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        
        String modifiedString = removeCharacter(input, charToRemove);
        System.out.println("Modified String: " + modifiedString);
    }
}

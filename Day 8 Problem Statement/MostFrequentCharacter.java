public class MostFrequentCharacter {

    public static char mostFrequentChar(String input) {
        int maxCount = 0;
        char mostFrequentChar = ' ';
        
        // Loop through all characters in the string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int count = 0;

            // Count occurrences of currentChar in the input string
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == currentChar) {
                    count++;
                }
            }

            // Update maxCount and mostFrequentChar if the currentChar has higher frequency
            if (count > maxCount) {
                maxCount = count;
                mostFrequentChar = currentChar;
            }
        }

        return mostFrequentChar;
    }

    public static void main(String[] args) {
        String input = "success";
        char result = mostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}

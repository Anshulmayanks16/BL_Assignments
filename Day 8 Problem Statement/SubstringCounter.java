public class SubstringOccurrences {

    public static int countOccurrences(String mainString, String subString) {
        int count = 0;
        int mainLength = mainString.length();
        int subLength = subString.length();
        
        // Loop through the main string
        for (int i = 0; i <= mainLength - subLength; i++) {
            boolean matchFound = true;
            
            // Compare the substring with the main string starting at index i
            for (int j = 0; j < subLength; j++) {
                if (mainString.charAt(i + j) != subString.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            
            // If a match is found, increment the count
            if (matchFound) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        String mainString = "This is a test string. This string is a test.";
        String subString = "is";
        
        int occurrences = countOccurrences(mainString, subString);
        System.out.println("The substring \"" + subString + "\" occurs " + occurrences + " times.");
    }
}

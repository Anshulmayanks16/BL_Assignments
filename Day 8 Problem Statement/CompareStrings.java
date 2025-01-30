public class CompareStrings {

    public static String compareStrings(String str1, String str2) {
        int i = 0;
        int length1 = str1.length();
        int length2 = str2.length();
        
        // Compare character by character
        while (i < length1 && i < length2) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            
            // If the characters are different, compare their ASCII values
            if (char1 < char2) {
                return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
            } else if (char1 > char2) {
                return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
            }
            i++;
        }
        
        // If all characters matched, compare the lengths
        if (length1 < length2) {
            return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
        } else if (length1 > length2) {
            return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
        }
        
        return "\"" + str1 + "\" is equal to \"" + str2 + "\"";
    }

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        
        String result = compareStrings(str1, str2);
        System.out.println(result);
    }
}

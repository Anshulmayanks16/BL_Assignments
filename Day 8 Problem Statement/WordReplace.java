public class WordReplace {

    public static String replace(String sentence, String target, String replacement) {
        String result = "";
        int i = 0;
        
        // Loop through the sentence
        while (i < sentence.length()) {
            // Check if the substring matches the target word
            if (i + target.length() <= sentence.length() && sentence.substring(i, i + target.length()).equals(target)) {
                // If match found, append the replacement word to the result
                result += replacement;
                i += target.length();  // Move past the target word
            } else {
                // If no match, add the current character to the result
                result += sentence.charAt(i);
                i++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String target = "fox";
        String replacement = "cat";

        String modifiedSentence = replace(sentence, target, replacement);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }
}

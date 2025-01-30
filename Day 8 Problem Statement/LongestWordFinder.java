public class LongestWordFinder {

    public static String findLongestWord(String sentence) {
        // Split the sentence into words using space as delimiter
        String[] words = sentence.split(" ");
        
        // Initialize variables to keep track of the longest word
        String longestWord = "";
        
        // Iterate through the words
        for (String word : words) {
            // If the current word is longer than the longestWord, update longestWord
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }

    public static void main(String[] args) {
        String sentence = "Write a Java program that takes a sentence as input";
        String longest = findLongestWord(sentence);
        System.out.println("The longest word is: " + longest);
    }
}

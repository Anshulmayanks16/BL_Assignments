public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Data structures and algorithms are essential.",
            "Learning to code is fun and rewarding."
        };

        String wordToFind = "Java";
        String result = findSentenceWithWord(sentences, wordToFind);

        System.out.println("Result: " + result);
    }
}
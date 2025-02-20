import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    // Cast a vote
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
        sortedVotes.put(candidate, voteCount.get(candidate));
    }

    // Get vote count for a candidate
    public int getVotes(String candidate) {
        return voteCount.getOrDefault(candidate, 0);
    }

    // Display votes in order of casting
    public void displayVoteOrder() {
        System.out.println("Votes in Order of Casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display votes sorted alphabetically (TreeMap)
    public void displaySortedResults() {
        System.out.println("Votes Sorted by Candidate Name:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display votes sorted by highest votes
    public void displayResultsByVotes() {
        System.out.println("Votes Sorted by Vote Count:");
        voteCount.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))  // Sort by votes descending
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " votes"));
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Cast votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        // Display results
        votingSystem.displayVoteOrder();
        votingSystem.displaySortedResults();
        votingSystem.displayResultsByVotes();
    }
}

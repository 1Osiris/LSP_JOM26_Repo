import java.util.HashMap;
import java.util.Map;


public class VotingMachine {
    private Map<String, Integer> candidates;


    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a new candidate to the voting machine.
     * If the candidate already exists, this method does nothing.
     *
     * @param name the name of the candidate to add
     */
    public void addCandidate(String name) {
        candidates.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for the specified candidate.
     * If the candidate doesn't exist, this method does nothing.
     *
     * @param name the name of the candidate to vote for
     */
    public void castVote(String name) {
        if (candidates.containsKey(name)) {
            int currentVotes = candidates.get(name);
            candidates.put(name, currentVotes + 1);
        }
    }

    /**
     * Returns a string representation of the current vote counts for all candidates.
     *
     * @return a string containing each candidate's name and their vote count
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
        }
        return result.toString();
    }
}

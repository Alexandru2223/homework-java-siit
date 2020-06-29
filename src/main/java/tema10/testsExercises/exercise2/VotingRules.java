package tema10.testsExercises.exercise2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing voting rules in an election
 */
public class VotingRules {
    
    /**
     * Complete this for Exercise_2_Test#getAllPersonsEligibleToVote
     * 
     * @param potentialVoters - voters to filter
     * @param legalAgeOfVoting - age where it's legal to vote
     * @return a list of eligible voters
     */
    public static List<Person> eligibleVoters(List<Person> potentialVoters, int legalAgeOfVoting) {
        // [your code here]
        List<Person> collect = potentialVoters.stream()
                                             .filter(x -> x.getAge() > legalAgeOfVoting)
                                             .collect(Collectors.toList());

        return collect;
    }
}

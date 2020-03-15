package ir.ac.aut.ceit.APWorkshop.VotingApp;

import java.util.ArrayList;


/**
 * VotingSystem class for managing votes
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class VotingSystem {

    /**
     * for holding all votes
     */
    private ArrayList<Voting> votingList;

    /**
     * VotingSystem class constructor to instantiate from this class
     */
    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    /**
     * to create new vote
     *
     * @param question vote question
     * @param type vote type (0 for single & 1 for multiple one)
     * @param polls vote polls
     * @throws Exception vote exception for poll existanse
     */
    public void createVoting(String question, int type, ArrayList<String> polls) throws Exception {
        Voting voting = new Voting(type, question);
        for(String poll : polls) {
            voting.createPoll(poll);
        }
    }

    /**
     * to get voting list
     *
     * @return an array of Voting
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    /**
     * to get specified voting
     *
     * @param index voting index
     * @return voting
     */
    public Voting getVoting(int index) {
        return votingList.get(index);
    }

    /**
     * to vote a voting
     *
     * @param index index of voting
     * @param person person who want to vote
     * @param polls his polls
     * @throws Exception exception
     */
    public void vote(int index, Person person, ArrayList<String> polls) throws Exception {
        votingList.get(index).vote(person, polls);
    }

    /**
     * result of a voting
     *
     * @param index index of voting
     */
    public void getResult(int index) {
        Voting voting = votingList.get(index);
        System.out.println(voting);
        System.out.println("number of participant: " + voting.getSize());
        voting.printVotes();
    }

    /**
     * print all voting information
     */
    public void printListOfVotings() {
        for(Voting voting : votingList) {
            System.out.println(voting);
        }
    }

}

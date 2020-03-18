package ir.ac.aut.ceit.APWorkshop.VotingApp;

import ir.huri.jcal.JalaliCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

/**
 * voting class for voting system
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Voting {

    /**
     * voting type
     */
    private int type;

    /**
     * voting question
     */
    private String question;

    /**
     * voting voters
     */
    private ArrayList<Person> voters;

    /**
     * voting polls
     */
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * voting class constructor for instantiate from this class
     *
     * @param type voting type
     * @param question voting question
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        this.voters = new ArrayList<>();
        this.polls = new HashMap<>();
    }

    /**
     * voting question
     *
     * @return voting question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * create new poll
     *
     * @param poll voting poll
     * @throws Exception exception if poll exists
     */
    public void createPoll(String poll) throws Exception {
        if(polls.containsKey(poll)) {
            throw new Exception("poll is already exists.");
        }
        polls.put(poll, new HashSet<>());
    }

    /**
     * vote to a poll
     *
     * @param person voter
     * @param pollsArray polls he voted
     *
     * @throws Exception exception if person voted before
     */
    public void vote(Person person, ArrayList<String> pollsArray) throws Exception {
        if(this.type == 0 && pollsArray.size() > 1) {
            throw new Exception("it is a single voting.");
        }
        if(voters.contains(person)) {
            throw new Exception("Person is already voted.");
        }
        JalaliCalendar date = new JalaliCalendar(new GregorianCalendar());
        for(String poll : pollsArray) {
            if(!polls.containsKey(poll)) continue;
            polls.get(poll).add(new Vote(person, date));
        }
    }

    /**
     * get voting voters
     *
     * @return voting voters
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * get number of voters
     *
     * @return number of voters
     */
    public int getSize() {
        return voters.size();
    }

    /**
     * get a specified poll's votes
     *
     * @param poll of voting
     * @return number of voters to this poll
     */
    public int getPollSize(String poll) {
        return polls.get(poll).size();
    }

    /**
     * get polls
     *
     * @return choices
     */
    public ArrayList<String> getPolls() {
        return (ArrayList<String>) polls.keySet();
    }

    /**
     * print votes
     */
    public void printVotes() {
        for(String poll : polls.keySet()) {
            System.out.println(poll + " :");
            System.out.println("number of votes is: " + getPollSize(poll));
            for(Vote vote : polls.get(poll)) {
                System.out.println(vote);
            }
        }
    }

    @Override
    public String toString() {
        return "Voting{" +
                "type=" + ((type == 0) ? "single" : "multi") +
                ", question='" + question + '\'' +
                '}';
    }
}

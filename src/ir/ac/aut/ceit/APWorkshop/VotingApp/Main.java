package ir.ac.aut.ceit.APWorkshop.VotingApp;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("fname1", "lname1");
        Person person2 = new Person("fname2", "lname2");
        Person person3 = new Person("fname3", "lname3");

        System.out.println(person1);
        System.out.println(person2.getFirstName());
        System.out.println(person3.getLastName());

        System.out.println("///////////////////////////////////");

        ArrayList<String> polls = new ArrayList<>();
        polls.add("poll 1");
        polls.add("poll 2");
        polls.add("poll 3");

        VotingSystem votingSystem = new VotingSystem();
        try {
            votingSystem.createVoting("question", 1, polls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            polls.remove(1);
            votingSystem.getVoting(0).vote(person1, polls);
            polls.remove(0);
            votingSystem.getVoting(0).vote(person2, polls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        votingSystem.printListOfVotings();

        votingSystem.getResult(0);
    }
}

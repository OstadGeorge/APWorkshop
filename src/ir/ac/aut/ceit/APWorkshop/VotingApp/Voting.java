package ir.ac.aut.ceit.APWorkshop.VotingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    int type;
    String question;
    ArrayList<Person> voters;
    HashMap<String, HashSet<Vote>> polls;
}

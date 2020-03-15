package ir.ac.aut.ceit.APWorkshop.VotingApp;

import ir.huri.jcal.JalaliCalendar;
import java.util.Objects;

/**
 * vote class for voting system
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Vote {

    /**
     * voter who voted
     */
    private Person person;

    /**
     * vote date
     */
    private JalaliCalendar date;

    /**
     * vote class constructor for instantiate from this class
     *
     * @param person voter
     * @param date vote date
     */
    public Vote(Person person, JalaliCalendar date) {
        this.person = person;
        this.date = date;
    }

    /**
     * voter
     *
     * @return person who voted
     */
    public Person getPerson() {
        return person;
    }

    /**
     * vote date
     *
     * @return vote date
     */
    public JalaliCalendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "person=" + person +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getPerson(), vote.getPerson()) &&
                Objects.equals(getDate(), vote.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson(), getDate());
    }
}

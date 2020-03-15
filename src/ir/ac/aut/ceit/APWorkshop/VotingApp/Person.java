package ir.ac.aut.ceit.APWorkshop.VotingApp;

import java.util.Objects;

/**
 * Person class for voting system
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Person {

    /**
     * person first name
     */
    private String firstName;

    /**
     * person last name
     */
    private String lastName;

    /**
     * person class constructor for instantiate from this class
     *
     * @param firstName person first name
     * @param lastName person last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * person first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * person last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}

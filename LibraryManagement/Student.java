/**
 * The Student class represents a student in a student administration system. It
 * holds the student details relevant in our context.
 *
 * @author Mohmmad Ali Heydari
 * @version 0.0
 */
public class Student {

    // the student’s first name
    private String firstName;

    // the student’s last name
    private String lastName;

    // the student ID
    private String id;

    // the grade
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param firstName first name of student
     * @param lastName  last name of student
     * @param studentID student ID
     */
    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = studentID;
        this.grade = 0;
    }

    /**
     * get the first name of student
     * 
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName set first name of a student
     */
    public void setFirstName(String firstName) {
        if (firstName.length() > 0) {
            this.firstName = firstName;
        }
    }

    /**
     * get the last name of student
     * 
     * @return lastName field
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * @param lastName set last name of a student
     */
    public void setlastName(String lastName) {
        if (lastName.length() > 0) {
            this.lastName = lastName;
        }
    }

    /**
     * get the id of student
     * 
     * @return id field
     */
    public String getId() {
        return id;
    }

    /**
     * @param id set id of a student
     */
    public void setId(String id) {
        if (id.length() > 0) {
            this.id = id;
        }
    }

    /**
     * get the grade of student
     * 
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade set grade of a student
     */
    public void setGrade(int grade) {
        if (grade > 0) {
            this.grade = grade;
        }
    }

    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }
}
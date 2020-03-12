/**
 * The Lab class represents a Lab in a student administration system. It holds
 * the Lab details relevant in our context.
 *
 * @author Mohmmad Ali Heydari
 * @version 0.0
 */
public class Lab {

    // the students list
    private Student[] students;

    // the avrage grade of a lab
    private int avg;

    // the day that lab will take a place
    private String day;

    // the capacity of a lab
    private int capacity;

    // the current size of a lab
    private int currentSize;

    /**
     * Create a new Lab with a given capacity and day.
     *
     * @param capacity capacity of lab
     * @param day      of lab
     */
    public Lab(int capacity, String day) {
        this.capacity = capacity;
        this.day = day;
        this.students = new Student[capacity];
    }

    /**
     * enroll a lab for a student
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * print a lab properties
     */
    public void print() {
        for (int i = 0; i < currentSize; ++i) {
            System.out.println("student first name: " + students[i].getFirstName() + "student id: "
                    + students[i].getId() + "student grade: " + students[i].getGrade());
        }
        System.out.println("Lab AVG: " + avg);
    }

    /**
     * get the student list of a lab
     * 
     * @return list of students in a lab
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * set the list of students in a lab
     * 
     * @param students
     */
    public void setStudents(Student[] students) {
        for (int i = 0; i < capacity; ++i) {
            this.students[i] = students[i];
        }
    }

    /**
     * get avrage grade of a lab
     * 
     * @return avrage grade
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculate the avrage grade of a lab
     */
    public void calculateAvg() {
        int sum = 0;
        for (int i = 0; i < currentSize; ++i) {
            sum += students[i].getGrade();
        }
        avg = sum / currentSize;
    }

    /**
     * get day of a lab
     * 
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * set day of a lab
     * 
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * get capacity of a lab
     * 
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set capacity of lab
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
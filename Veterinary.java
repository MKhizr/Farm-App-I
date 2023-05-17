import java.util.Date;


/**
 * Class for veterinary which manages all the data related to veterinary which provides treatment to a cow and has all the constructors, getters, setters, a print function to print the details of the veterinary.
 * @author Muhammad Khizr Shahid 2413235
 * @version 1.0
 */
public class Veterinary {

    private int vetID;
    private String gender;
    private Date dateOfBirth;
    private double salary;

    /**
     * Default constructor for veterinary.
     */
    public Veterinary() {
        vetID =0;
        gender = null;
        dateOfBirth = null;
        salary = 0;

    }

    /**
     * Parametrized constructor for veterinary.
     *
     * @param vetID       is the ID of veterinary.
     * @param gender      is the gender of the veterinary.
     * @param dateOfBirth is the date of birth of the veterinary.
     */
    public Veterinary(int vetID, String gender, Date dateOfBirth) {
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = 0;
    }

    /**
     * Parametrized constructor for veterinary.
     *
     * @param vetID       is the ID of veterinary.
     * @param gender      is the gender of the veterinary.
     * @param dateOfBirth is the date of birth of the veterinary.
     * @param salary      is the salary of the veterinary.
     */
    public Veterinary(int vetID, String gender, Date dateOfBirth, double salary) {
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    /**
     * Gives vet id.
     *
     * @return the vet id
     */
    public int getVetID() {
        return vetID;
    }

    /**
     * Gives gender of vet.
     *
     * @return the gender of vet.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets date of birth of vet.
     *
     * @return the date of birth of vet.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets salary of vet.
     *
     * @return the salary of vet.
     */
    public double getSalary() {
        return salary;
    }


    /**
     * Sets vet id.
     *
     * @param vetID the vet id
     */
    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    /**
     * Sets gender of vet.
     *
     * @param gender the gender of vet.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets date of birth of vet.
     *
     * @param dateOfBirth the date of birth of vet.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets salary of vet.
     *
     * @param salary the salary of vet.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Prints all the details of the veterinary.
     */
    public void printVet() {

        System.out.println("Vet ID is: " + getVetID());
        System.out.println("Gender: " + getGender());
        System.out.println("Date of birth: " + getDateOfBirth());
        System.out.println("Salary: " + getSalary());

    }

}


import java.time.*;
import java.util.ArrayList;
import java.util.Date;


/**
 * Class for cow which manages all the basic information related to cow and has all the constructors, getters, setters for the cows, function to calculate the age of a cow and a function to print the details of the cows.
 *
 * @author Muhammad Khizr Shahid 2413235
 * @version 1.0
 */
public class Cow {

    private int tagNo;
    private String gender;
    private Date dateOfBirth;
    private boolean purchased;
    private ArrayList<Treatment> treatments;


    /**
     * Instantiates a new Cow.
     */
    public Cow() {
        tagNo = 0;
        treatments = new ArrayList<Treatment>();
        gender = null;
        dateOfBirth = null;
        purchased = false;
    }

    /**
     * Parametrized constructor for the cow.
     * @param tagNo is the tag number of the cow.
     * @param gender is the gender of the cow.
     * @param dateOfBirth is the date of birth of the cow.
     * @param purchased tells whether cow was purchased or farm raised.
     */
    public Cow(int tagNo, String gender, Date dateOfBirth, boolean purchased) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        treatments = new ArrayList<Treatment>();

    }

    /**
     * Parametrized constructor for the cow.
     *
     * @param tagNo       is the tag number of the cow.
     * @param gender      is the gender of the cow.
     * @param dateOfBirth is the date of birth of the cow.
     * @param purchased   tells whether cow was purchased or farm raised.
     * @param treatments  is the treatments for the cow.
     */
    public Cow(int tagNo, String gender, Date dateOfBirth, boolean purchased, ArrayList<Treatment> treatments) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.treatments = new ArrayList<Treatment>();
    }

    /**
     * Parametrized constructor for the cow.
     *
     * @param tagNo       is the tag number of the cow.
     * @param gender      is the gender of the cow.
     * @param dateOfBirth is the date of birth of the cow.
     * @param purchased   tells whether cow was purchased or farm raised.
     * @param treatment   is the treatment for the cow.
     */
    public Cow(int tagNo, String gender, Date dateOfBirth, boolean purchased, Treatment treatment) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.treatments = new ArrayList<Treatment>();
        this.treatments.add(treatment);
    }

    /**
     * Computes the age of a cow based on the tag number of the cow.
     */
    public void getAge() {

        Date D = getDateOfBirth();
        Instant I = D.toInstant();
        ZonedDateTime Z = I.atZone(ZoneId.systemDefault());
        LocalDate L = Z.toLocalDate();
        Period P =Period.between(L, LocalDate.now());
        System.out.println("Cow is " + P.getYears() + " years " + P.getMonths() + " months and " + P.getDays() + " days old." + "\n");

    }


    /**
     * Gets tag no of cow.
     *
     * @return the tag no cow
     */
    public int getTagNo() {
        return tagNo;
    }

    /**
     * Gets gender of cow.
     *
     * @return the gender of cow.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets date of birth of cow.
     *
     * @return the date of birth of cow.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Boolean which tells if cow is purchased or farm raised.
     *
     * @return the boolean for cow.
     */
    public boolean isPurchased() {
        return purchased;
    }

    /**
     * Gets treatments of cow.
     *
     * @return the treatments of cow.
     */
    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }


    /**
     * Sets tag no of cow.
     *
     * @param tagNo the tag no of cow.
     */
    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * Sets gender of cow.
     *
     * @param gender the gender of cow.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets date of birth of cow.
     *
     * @param dateOfBirth the date of birth of cow.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets boolean for cow whether it is purchased or farm raised.
     *
     * @param purchased the purchased boolean of cow.
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Sets treatments for cow.
     *
     * @param treatments the treatments of cow.
     */
    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }

    /**
     * Prints all the details of the cow and calls print function of veterinary and treatment to print those details.
     */
    public void printCow() {

            System.out.println("Details of cow are: ");

            System.out.println("Tag no  of cow: " + getTagNo());
            if (isPurchased() == true) {
                System.out.println("Cow is purchased.");
            }
            else if (isPurchased() == false) {
                System.out.println("Cow is farm raised.");
            }
            System.out.println("Date of birth of cow: " + getDateOfBirth());
            System.out.println("Gender of cow: " + getGender() + "\n");


            for (int i =0; i<treatments.size(); i++){
                System.out.println("Details of vet who provided the treatment are: "+ "\n");
                treatments.get(i).getVetObj().printVet();
                System.out.println("\n");

                System.out.println("Details of treatment are: "+ "\n");
                treatments.get(i).printTreatment();
                System.out.println("\n");
            }
    }


}

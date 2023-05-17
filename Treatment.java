import java.util.ArrayList;
import java.util.Date;

/**
 * Class for Treatment which manages all the data related to the treatment provided to the cow and has all the constructors, getters, setters and a function to print the details of the treatments.
 * @author Muhammad Khizr Shahid 2413235
 * @version 1.0
 */
public class Treatment {

    private Date dateOfTreatment;
    private String details;
    private ArrayList<Medication> medications;

    private Veterinary VetObj;

    /**
     * Default constructor for Treatemnt.
     */
    public Treatment() {

        dateOfTreatment =null;
        details=null;
        medications =  new ArrayList<Medication>();
        VetObj = null;

    }

    /**
     * Parametrized constructor for Treatment.
     *
     * @param dateOfTreatment is the date of treatment.
     * @param details         is the details of treatment.
     * @param medication      is the medication for the treatment.
     * @param vetObj          is the veterinary for the treatment.
     */
    public Treatment(Date dateOfTreatment, String details, Medication medication, Veterinary vetObj) {
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        medications = new ArrayList<Medication>();
        medications.add(medication);
        VetObj = vetObj;
    }

    /**
     * Parametrized constructor for Treatment.
     *
     * @param dateOfTreatment is the date of treatment.
     * @param details         is the details of treatment.
     * @param medications     is the medication for the treatment.
     * @param vetObj          is the veterinary for the treatment.
     */
    public Treatment(Date dateOfTreatment, String details, ArrayList<Medication> medications, Veterinary vetObj) {
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        this.medications = new ArrayList<Medication>();
        this.VetObj = vetObj;
    }


    /**
     * Gives vet obj of vet who treated that cow
     *
     * @return the vet obj
     */
    public Veterinary getVetObj() {
        return VetObj;
    }

    /**
     * Gives date of treatment of cow.
     *
     * @return date of treatment of cow
     */
    public Date getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**
     * Gives details of treatment of cow.
     *
     * @return the details of treatment of cow.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Gets medications of cows
     *
     * @return the medications of cow
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * Sets date of treatment of cow.
     *
     * @param dateOfTreatment the date of treatment
     */
    public void setDateOfTreatment(Date dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * Sets details of treatment of cow.
     *
     * @param details the details of treatment
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Sets medications for treatment of cow
     *
     * @param medications the medications of treatment
     */
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    /**
     * Sets vet obj.
     *
     * @param vetObj the vet obj
     */
    public void setVetObj(Veterinary vetObj) {

        VetObj = vetObj;
    }

    /**
     * Prints all the details of the treatment for the cow and calls print function of medication to print those details.
     */
    public void printTreatment() {

        System.out.println("Date of treatment of cow: " + getDateOfTreatment());
        System.out.println("Details of treatment of cow: " + getDetails() + "\n");

        for (int i =0; i<medications.size(); i++){
            System.out.println("Details of medication are: "+ "\n");
            medications.get(i).printMedication();
        }

    }
}

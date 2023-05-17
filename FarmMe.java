import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * The FarmMe app is an application which allows users to manage their farm using an application. User can add and delete cows and veterinaries in this application. They can store treatments and medications for cows along with the veterinary
 * details who provided the treatments. Full details of cow along with their treatments and medications can be seen and they can manage their entire farm using this application.
 *
 * @author Muhammad Khizr Shahid 2413235
 * @version 1.0
 */
public class FarmMe {
    public static ArrayList<Cow> cows = new ArrayList<Cow>();
    public static ArrayList<Veterinary> vets = new ArrayList<Veterinary>();

    /**
     * This main function of the class is responsible to populate the application with initial data of cows, treatment, medications and vets.
     * It deals with all the other inner function calls such as add, delete, display cow and vet details and also displays the menu. User is asked to enter a value from the menu and this main function then calls the appropriate function to execute that command.
     *
     * @param args This program does not have any command line arguments.
     * @throws ParseException the parse exception
     */
    public static void main(String[] args) throws ParseException {
        PopulateData.PopulateInitialData(cows, vets);

        int Value = 0;

        while(Value != 13) {

            menu();
            Value = TagProvider();

            if (Value == 1) {

                addCow();

            } else if (Value == 2) {

                System.out.println("Enter tag number of cow you want to delete: ");
                int tagNo = TagProvider();
                deleteCow(tagNo);

            } else if (Value == 3) {

                System.out.println("Enter tag number of cow you want details of: ");
                int tagNo = TagProvider();
                getCowDetails(tagNo);

            } else if (Value == 4) {
                addVet();

            } else if (Value == 5) {

                System.out.println("Enter ID of vet you want to delete: ");
                int vetID = TagProvider();
                deleteVet(vetID);

            } else if (Value == 6) {

                System.out.println("Enter ID of vet you want details of: ");
                int vetID = TagProvider();
                getVetDetails(vetID);

            } else if (Value == 7) {

                System.out.println("Enter ID of vet: ");
                int vetID = TagProvider();
                System.out.println("Enter tag number of cow: ");
                int tagNo = TagProvider();
                addTreatment(vetID, tagNo);

            } else if (Value == 8) {

                System.out.println("Enter tag number of cow you want treatment of: ");
                int tagNo = TagProvider();
                getCowTreatment(tagNo);

            }  else if (Value == 9) {

                System.out.println("Enter tag number of cow you want treatment of: ");
                int tagNo = TagProvider();

                System.out.println("Enter date of treatment in dd-MM-yyyy format: ");
                Date dateOfTreatment =DateGenerator();

                getCowTreatment(tagNo, dateOfTreatment);

            }
            else if (Value == 10) {
                listCows();

            } else if (Value == 11) {
                listVet();
            }
            else if (Value == 12) {

                boolean founder = false;

                System.out.println("Please enter tag number of cow you want age of:  ");
                int tag = TagProvider();

                for(int i=0; i< cows.size(); i++) {
                    if (tag == cows.get(i).getTagNo()) {
                        founder = true;
                        cows.get(i).getAge();
                        break;
                    }
                }

                if (founder == false) {
                    System.out.println("Cow with tag number " + tag + " not found.");
                }

            }
            else if (Value == 13) {
                exit();
            }

        } 

    }

    /**
     * Displays the menu of the program which shows the functionalities this application offers.
     */
    public static void menu(){
        System.out.println("1) Press 1 to add a cow. ");
        System.out.println("2) Press 2 to delete a cow. ");
        System.out.println("3) Press 3 to get cow details. ");
        System.out.println("4) Press 4 to add a vet. ");
        System.out.println("5) Press 5 to delete a vet. ");
        System.out.println("6) Press 6 to get vet details. ");
        System.out.println("7) Press 7 to add treatment. ");
        System.out.println("8) Press 8 to get cow treatment. ");
        System.out.println("9) Press 9 to get cow treatment on a given date. ");
        System.out.println("10) Press 10 to list all cows. ");
        System.out.println("11) Press 11 to list all vets. ");
        System.out.println("12) Press 12 to get age of a cow. ");
        System.out.println("13) Press 13 to exit. ");
    }

    /**
     * Adds a cow to the application after asking and taking a series of inputs for the details of the cow such as tag number, date of birth, gender and raising method.
     */
    public static void addCow() {


        System.out.println("Enter tag number: ");
        int Tag = TagProvider();

        boolean found = false;

        for(int i = 0; i <cows.size(); i++) {
            if (Tag == cows.get(i).getTagNo()) {
                found = true;
            }
        }

        if (found == false) {

            Scanner inputTaker = new Scanner(System.in);
            Cow TempCow = new Cow();
            TempCow.setTagNo(Tag);

            System.out.println("Enter date of birth in dd/MM/yyyy format: ");
            Date birthday = DateGenerator();
            TempCow.setDateOfBirth(birthday);

            String gender = GenderGenerator();
            TempCow.setGender(gender);

            System.out.println("Enter 'true' if cow is purchased and 'false' if cow is farm raised: ");
            boolean tempbool = inputTaker.nextBoolean();
            TempCow.setPurchased(tempbool);

            cows.add(TempCow);
        }

        else
            System.out.println("Cow with tag number " + Tag + " already exists. Please select a different tag number.");

    }

    /**
     * Deletes a cow and all its relevant data from the application completely based on its tag number.
     * @param tagNo is the tag number of cow to be deleted.
     */
    public static void deleteCow(int tagNo) {

        boolean found = false;
        int deleterPosition = 0;

        for( int i=0; i<cows.size(); i++) {
            if (tagNo == cows.get(i).getTagNo()){
                found = true;
                deleterPosition = i;

            }
        }

        if (found == true) {
            cows.remove(deleterPosition);
            System.out.println("Cow with tag number " + tagNo + "has been deleted" + "\n");
        }
        else {
            System.out.println("Cow with tag number " + tagNo + " not available. Please enter a valid tag number." + "\n");
        }

    }

    /**
     * Displays full details of a specific cow including all its treatment, its medications and the veterinary details based on its tag number.
     * @param tagNo is the tag number of the cow to be deleted
     */
    public static void getCowDetails(int tagNo) {

        boolean found = false;

        for (int i =0; i < cows.size(); i++) {
            if (tagNo == cows.get(i).getTagNo()) {
                found = true;
                cows.get(i).printCow();
            }

        }

        if (found == false) {
            System.out.println("Cow with tag number " + tagNo + " not available. Please enter a valid tag number." + "\n");
        }



    }

    /**
     * Adds a veterinary to the application after asking and taking a series of inputs for the details of the veterinary such as ID, date of birth, gender and salary.
     */
    public static void addVet()  {

        boolean found = false;

        System.out.println("Enter Vet ID: ");
        int tempid = TagProvider();

        for (int i =0; i< vets.size(); i++) {
            if( tempid == vets.get(i).getVetID()) {
                found = true;
            }
        }
        if (found == false) {

            Scanner inputTaker = new Scanner(System.in);
            Veterinary tempVet = new Veterinary();

            tempVet.setVetID(tempid);

            String gender = GenderGenerator();
            tempVet.setGender(gender);

            System.out.println("Enter date of birth in dd/MM/yyyy format: ");
            Date birthday = DateGenerator();
            tempVet.setDateOfBirth(birthday);

            System.out.println("Enter salary: ");
            double tempsalary = inputTaker.nextDouble();
            tempVet.setSalary(tempsalary);

            vets.add(tempVet);
        }

        else {
            System.out.println("Vet with ID " + tempid + " already exists. Please enter another ID.");
        }

    }

    /**
     * Deletes a vet from the application completely based on its ID.
     * @param vetID is the ID of veterinary to be deleted.
     */
    public static void deleteVet(int vetID) {

        boolean found = false;
        int deleterPosition = 0;

        for( int i=0; i<vets.size(); i++) {
            if (vetID == vets.get(i).getVetID()) {
                found = true;
                deleterPosition = i;
            }
        }

        if (found == true) {
            vets.remove(deleterPosition);
            System.out.println("Vet with ID " + vetID + "has been deleted" + "\n");
        }
        else {
            System.out.println("Vet with ID " + vetID + " not available. Please enter a valid ID." + "\n");
        }

    }

    /**
     * Displays full details of a veterinary such as ID, gender, date of birth and salary based on the ID.
     * @param vetID is the ID of veterinary to be displayed.
     */
    public static void getVetDetails(int vetID) {

        boolean found = false;

        for( int i=0; i<vets.size(); i++) {
            if (vetID == vets.get(i).getVetID()) {
                found = true;
                System.out.println("Vet ID is: " + vets.get(i).getVetID());
                System.out.println("Gender: " + vets.get(i).getGender());
                System.out.println("Date of birth: " + vets.get(i).getDateOfBirth());
                System.out.println("Salary: " + vets.get(i).getSalary());
            }
        }

        if (found == false) {
            System.out.println("Vet with ID " + vetID + " not available. Please enter a valid ID." + "\n");
        }
    }

    /**
     * Adds treatment to a cow and its relevant medication by asking and taking a series of inputs from the user such as date of treatment, details of treatment;
     * details, duration, start date, dosage and notes of medication along with a veterinary who gave that treatment
     * @param vetId is the ID of veterinary who gave the treatment
     * @param tagNo is the tag number of cow who received that treatment and medication
     */
    public static void addTreatment(int vetId,int tagNo) {

        boolean CowCheck = false;
        boolean VetCheck = false;
        int CowIndexPosition=0;


        for (int i=0; i< cows.size(); i++) {
            if (tagNo == cows.get(i).getTagNo()){
                CowCheck = true;
                CowIndexPosition = i;
            }
        }

        for (int i=0; i< vets.size(); i++) {
            if (vetId == vets.get(i).getVetID()){
                VetCheck = true;

            }
        }

        if (CowCheck == true && VetCheck == true) {

            char choice;
            do {
                Scanner inputTaker = new Scanner(System.in);
                Treatment tempTreatment = new Treatment();
                Medication tempMedication = new Medication();

                System.out.println("Enter date of treatment in dd/MM/yyyy format: ");
                Date TreatmentDate = DateGenerator();
                tempTreatment.setDateOfTreatment(TreatmentDate);

                System.out.println("Enter details of treatment: ");
                String Treatmentdetails = inputTaker.nextLine();
                tempTreatment.setDetails(Treatmentdetails);



                System.out.println("Enter details of medication: ");
                String Medicationdetails = inputTaker.nextLine();
                tempMedication.setDetails(Medicationdetails);

                System.out.println("Enter duration of medication: ");
                int medicationduration = Integer.parseInt(inputTaker.nextLine());
                tempMedication.setDuration(medicationduration);


                System.out.println("Enter start date of medication in dd/MM/yyyy format: ");
                Date MedicationDate = DateGenerator();
                tempMedication.setStartDate(MedicationDate);


                System.out.println("Enter dosage of medication: ");
                double Medicationdosage = Double.parseDouble(inputTaker.nextLine());
                tempMedication.setDosage(Medicationdosage);

                System.out.println("Enter notes of medication: ");
                String Medicationnotes = inputTaker.nextLine();
                tempMedication.setNotes(Medicationnotes);

                tempTreatment.getMedications().add(tempMedication);

                for(int i=0; i<vets.size(); i++) {
                    if (vetId == vets.get(i).getVetID()){
                        Veterinary tempVet = vets.get(i);
                        tempTreatment.setVetObj(tempVet);
                        break;
                    }
                }

                cows.get(CowIndexPosition).getTreatments().add(tempTreatment);


                Scanner inputTakerChoice = new Scanner(System.in);
                System.out.println("Do you want to add more treatments for this cow? (Y/N)");
                choice = inputTakerChoice.next().charAt(0);

            }while (choice == 'Y' || choice == 'y');
        }

        else if (CowCheck == false && VetCheck == true) {
            System.out.println("No such cow found");
        }

        else if (CowCheck == true && VetCheck == false) {
            System.out.println("No such vet found");
        }

        else if (CowCheck == false && VetCheck == false) {
            System.out.println("No such vet or cow found");
        }
    }

    /**
     * Displays full details of all the treatments and medications given to a specific cow with a unique tag number.
     * @param tagNo is the tag number of whos treatment details are required.
     */
    public static void getCowTreatment(int tagNo){

        boolean found = false;

        for (int i =0; i < cows.size(); i++) {
            if (tagNo == cows.get(i).getTagNo()) {
                found = true;
                for (int j=0; j < cows.get(i).getTreatments().size(); j++ ) {
                    cows.get(i).getTreatments().get(j).getVetObj().printVet();
                    cows.get(i).getTreatments().get(j).printTreatment();

                }
            }
        }

        if (found == false) {
            System.out.println("Cow with tag number " + tagNo + " not available. Please enter a valid tag number." + "\n");
        }

    }

    /**
     * Displays full details of all the treatments and medications given to a specific cow with a unique tag number on the given date.
     * @param tagNo is the tag number of the cow whos treatment and medication details are required.
     * @param dateOfTreatment is the date when that cow received that treatment.
     */
    public static void getCowTreatment(int tagNo, Date dateOfTreatment){

        boolean tagFounder = false;
        boolean dateFounder = false;

        for (int i =0; i < cows.size(); i++) {
            if ( (tagNo == cows.get(i).getTagNo())  ){
                tagFounder = true;
                for (int j=0; j < cows.get(i).getTreatments().size(); j++ ) {
                    if(dateOfTreatment.equals(cows.get(i).getTreatments().get(j).getDateOfTreatment())) {
                        dateFounder = true;
                        cows.get(i).getTreatments().get(j).getVetObj().printVet();
                        cows.get(i).getTreatments().get(j).printTreatment();
                    }
                }
            }
        }

        if (tagFounder == false) {
            System.out.println("Cow with tag number " + tagNo + " not available" + "\n");
        }

        else if  (tagFounder == true && dateFounder == false) {
            System.out.println("Treatment of cow with tag " + tagNo + " on the given date not available" + "\n");
        }

    }

    /**
     * Displays full details of all the cows and their relevant treatments and medications.
     */
    public static void listCows() {

        for (int i =0; i<cows.size(); i++){
            System.out.println("Details of cow " + (i+1) + " : " + "\n");
            cows.get(i).printCow();
            System.out.println("\n");
        }

    }

    /**
     * Displays full details of all the veterinaries.
     */
    public static void listVet() {
        for (int i =0; i<vets.size(); i++){
            System.out.println("Details of vet " + (i+1) + " : " + "\n");
            vets.get(i).printVet();
            System.out.println("\n");
        }

    }

    /**
     * Allows user to exit the application.
     */
    public static void exit() {
        System.out.println("Leaving application. Bye!");
        System.exit(0);

    }

    /**
     * Creates a date from the information entered by the user.
     * @return returns a date.
     */
    public static Date DateGenerator()  {

        boolean correct =true;
        Date finalDate=null;

        Scanner inputTaker = new Scanner(System.in);
       do {
           correct = true;
           try {

               String tempdate = inputTaker.next();
               SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
               finalDate = format.parse(tempdate);

           } catch (DateTimeParseException | ParseException E) {
               System.out.println("Please enter correct date");
               correct=false;
               inputTaker.nextLine();
           }
       }while (!correct);

       return finalDate;
    }

    /**
     * Takes input from user about the tag number of a cow or ID of a veterinary.
     * @return returns the tag number of a cow or the ID of the vet based on the usage of the function.
     */
    public static int TagProvider () {

        Scanner temp = new Scanner(System.in);
        int tagNo = 0;
        boolean correct = true;
        do {
            correct = true;
            if(temp.hasNextInt()) {
                tagNo = temp.nextInt();
            }
            else {
                System.out.println("Wrong input, try again.");
                temp.next();
                correct = false;
            }
        }
        while(!correct);
        return tagNo;

    }

    /**
     * Creates a string of gender for veterinary or the cow based on the usage of the function.
     * @return returns gender of veterinary or the cow based on the usage
     */
    public static String GenderGenerator(){

        Scanner inputTaker = new Scanner(System.in);
        String gender;
        do {

            System.out.println("Enter gender: ");
            gender = inputTaker.next();

        } while(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")));

        return gender;
    }

}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

/**
 * A class to populate the application with initial data of cows, their treatments, relevant medications for those treatments and the veterinary as an external database is not being used currently.
 * @author Muhammad Khizr Shahid 2413235
 * @version 1.0
 */
public class PopulateData {

    /**
     * Populates the application with 3 veterinaries, 3 cows and their treatments along with their relevant medications.
     * @param cows is the array list of cow with populated cows.
     * @param vets is the array list of vets with populated vets
     * @throws ParseException the exception
     */
    public static void PopulateInitialData(ArrayList<Cow> cows, ArrayList<Veterinary> vets) throws ParseException {

        Date DateObj;
        SimpleDateFormat DateFormat = new SimpleDateFormat ("dd/MM/yyyy");

        DateObj =DateFormat.parse("03/09/1987");
        Veterinary Vet1 = new Veterinary(1,"Male",DateObj,30213 );
        vets.add(Vet1);

        DateObj =DateFormat.parse("03/09/1990");
        Veterinary Vet2 = new Veterinary(2,"Female",DateObj,40000 );
        vets.add(Vet2);

        DateObj =DateFormat.parse("03/09/1985");
        Veterinary Vet3 = new Veterinary(3,"Male",DateObj,65000 );
        vets.add(Vet3);


        DateObj =DateFormat.parse("05/07/2007");
        Medication medication1 = new Medication("Montiplus - AntiFungal",3,DateObj,10,"5 weeks");
        Treatment treatment1 = new Treatment(DateObj,"Botulism",medication1,Vet1);

        DateObj =DateFormat.parse("01/01/2005");
        Cow Cow1 =new Cow(1,"Male",DateObj,true,treatment1);



        DateObj =DateFormat.parse("05/07/2011");
        Medication medication2 = new Medication("Pelarome - Antibiotic",3,DateObj,5,"3 weeks");
        Treatment treatment2 = new Treatment(DateObj,"Blutongue",medication2,Vet2);

        DateObj =DateFormat.parse("05/05/2010");
        Cow Cow2 =new Cow(2,"Female",DateObj,false,treatment2);




        DateObj =DateFormat.parse("05/07/2015");
        Medication medication3 = new Medication("TelaPharm - Antiobiotic",1,DateObj,9,"9 weeks");
        Treatment treatment3 = new Treatment(DateObj,"Lumpy skin",medication3,Vet3);

        DateObj =DateFormat.parse("09/09/2012");
        Cow Cow3 =new Cow(3,"Female",DateObj,false,treatment3);


        cows.add(Cow1);
        cows.add(Cow2);
        cows.add(Cow3);

    }


}

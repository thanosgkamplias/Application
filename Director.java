//Κλάση Director για την δημιουργία διευθυντή τμήματος που κληρονομεί απο την κλάση EmployeeBasic το όνομα και το επίθετο του εργαζομένου
public class Director extends EmployeeBasic {
    // Δήλωση μεταβλητών - Στοιχείων εργαζομένου
    private DateTime dutiesStart;        // Ημερομηνία έναρξης των καθηκόντων του
    private DateTime dutiesEnd;          // Ημερομηνία λήξης των καθηκόντων του

    //Constructor
    public Director(String firstName, String lastName, DateTime dutiesStart){
        super(firstName, lastName);
        this.dutiesStart = new DateTime(dutiesStart);
        this.dutiesEnd = new DateTime(); //θα παίρνει default τιμή - 0
    }

    //Μέθοδος 'getDutiesStart()' η οποία επιστρέφει την μεταβλητή dutiesStart
    public DateTime getDutiesStart(){
        return dutiesStart; //επιστρέφει την ημερομηνία έναρξης
    }

    //Μέθοδος 'getDutiesEnd()' η οποία επιστρέφει την μεταβλητή dutiesEnd
    public DateTime getDutiesEnd(){
        return dutiesEnd; //επιστρέφει την ημερομηνία λήξης
    }

    //Μέθοδος για την απεγγραφή ενός εργαζομένου απο διευθυντή
    public void Unregister(DateTime timeEnd){
        this.dutiesEnd = new DateTime(timeEnd);
    }

}

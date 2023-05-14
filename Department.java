import java.util.ArrayList;

//κλάση Department για την δημιουργία τμημάτων της εταιρίας
public class Department {
    //Δήλωση μεταβλητών - Στοιχείων του τμήματος
    private  String nameOfDepartment;                              //όνομα τμήματος
    private  String descriptionOfDepartment;                       //περιγραφή σχετικά με το αντικείμενο του τμήματος
    private  ArrayList <Director> directorsHistory = new ArrayList<Director>();  /* Δημιουργία δυναμικού πίνακα που θα περιλαμβάνει
    τους διευθυντές που βρίσκονται σε κάποιο τμήμα της εταιρίας */

    private ArrayList <EmployeeBasic> employees = new ArrayList<EmployeeBasic>();  /* Δημιουργία δυναμικού πίνακα που θα περιλαμβάνει
    τα βασικά στοιχεία των εργαζομομένων (όνομα και επίθετο) που ανήκουν σε κάποιο τμήμα της εταιρίας */

    //Constructor
    public Department(String nameOfDepartment, String descriptionOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
        this.descriptionOfDepartment = descriptionOfDepartment;
    }

    //Μέθοδος η οποία επιστρέφει ένα String που περιλαμβάνει όλα τα στοιχεία ενός τμήματος
    public String DepartmentToString(){
        return this.nameOfDepartment + ":" + this.descriptionOfDepartment;
    }

    //Μέθοδος 'getNameOfDepartment()' η οποία επιστρέφει την μεταβλητή nameOfDepartment
    public String getNameOfDepartment(){
        return nameOfDepartment;
    }

    //Μέθοδος 'getDescriptionOfDepartment()' η οποία επιστρέφει την μεταβλητή descriptionOfDepartment
    public String getDescriptionOfDepartment(){
        return descriptionOfDepartment;
    }

    //Μέθοδος για την εγγραφή κάποιου εργαζομένου στην λίστα employees
    public void RegisterEmployee(EmployeeBasic e){
        //Αν ο εργαζόμενος δεν υπάρχει στην λίστα τότε προσθεσέ τον στην λίστα employees
        if(!isEmployeeInList(e))
            employees.add(e);
    }

    //Μέθοδος για την διαγραφή κάποιου εργαζομένου απο την λίστα employees
    public void deleteEmployee(EmployeeBasic e){
        if(isEmployeeInList(e))  //Αν ο εργαζόμενος υπάρχει στην λίστα (true)
            employees.remove(e);  //τοτε τον αφαιρεί απο την λίστα
    }

    //Μέθοδος η οποία ελέγχει αν ο εργαζόμενος υπάρχει στην λίστα employees
    public boolean isEmployeeInList(EmployeeBasic e){
        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "employees.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i=0;i<employees.size();i++){
            /*Αν το όνομα του εργαζομένου στην λίστα είναι το ίδιο με το όνομα του εργαζομένου που ορίσαμε στην κλάση Employee και
            Αν το επίθετο του εργαζομένου στην λίστα είναι το ίδιο με το επίθετο του εργαζομένου που ορίσαμε στην κλάση Employee */
            if(employees.get(i).getFirstName().equals(e.getFirstName()) && employees.get(i).getLastName().equals(e.getLastName()))
                return true; //επέστρεψε true(1)
        }
        return false; //επέστρεψε false(0)
    }

    //Μέθοδος για την απεγγραφή του προηγούμενου διευθυντή
    private void UnregisterPreviousDirector(DateTime dt){
        //Πρέπει να υπάρχει τουλάχιστον ένας διευθυντής για να εκτελέσει την μέθοδο UnregisterPreviousDirector
        if(directorsHistory.size() < 1)
            return; //επιστροφή, δεν εκτελούνται οι επόμενες εντολές
        Director r = directorsHistory.get(directorsHistory.size()-1);
        r.Unregister(dt);
    }

    //Μέθοδος για την αντικατάσταση νέου διευθυντή σε τμήμα της εταιρίας
    public void RegisterDirector(String firstName, String lastName, DateTime dateStart){
        UnregisterPreviousDirector(dateStart); //Τελείωνει - λήγει τα καθήκοντα του τρέχοντος director(διευθυντή)
        Director r = new Director(firstName, lastName,dateStart);  //Ορισμός νέου director(διευθυντή)
        directorsHistory.add(r); //προσθέτει στην λίστα "directorsHistory" τον νέο διευθυντή

    }

    //Επιστρέφει τους Employees που ανήκουν στο τμήμα
    public ArrayList <EmployeeBasic> getEmployees(){
        return employees;
    }

    //Επιστρέφει τον τελευταίο Director του τμήματος (είναι ο τελευταίος που προστέθηκε στη λίστα "directorsHistory")
    public Director getDirector(){
        if(directorsHistory.size() > 0){
            return directorsHistory.get(directorsHistory.size()-1);
        }
        return null; // Στην περίπτωση που δεν έχουμε ορίσει διευθυντή θα επιστρέψει null
    }
}
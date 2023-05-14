//κλάση EmployeeBasic που περιλαμβάνει μόνο τις βασικές πληροφορίες ενός εργαζομένου (Όνομα και επίθετο)
public class EmployeeBasic {
    // Δήλωση μεταβλητών - όνομα και επίθετο του εργαζομένου
    private String firstName;            // Όνομα
    private String lastName;             // Επίθετο

    //Constructor
    public EmployeeBasic(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Μέθοδος 'setFirstName' η οποία ορίζει την τιμή της μεταβλητής firstName
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //Μέθοδος 'setLastName' η οποία ορίζει την τιμή της μεταβλητής lastName
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Μέθοδος 'getFirstName()' η οποία επιστρέφει την μεταβλητή firstName
    public String getFirstName(){
        return firstName; //επιστρέφει το όνομα του εργαζομένου
    }

    //Μέθοδος 'getLastName()' η οποία επιστρέφει την μεταβλητή lastName
    public String getLastName(){
        return lastName; //επιστρέφει το επίθετο του εργαζομένου
    }

    //Δημιουργία του fullName - ονοματεπώνυμο
    private String getFullName(){
        return firstName + " " + lastName; /* επιστρέφει την συνένωση των 2 String ("firstName" και "lastName")
        για να παραχθεί το ονοματεπώνυμο του εργαζομένου */
    }
}


//Κλάση ProjectFinance που περιλαμβάνει τα οικονομικά στοιχεία ενός Project - έργου (έσοδα,δαπάνες)
public class ProjectFinance {
    // Δήλωση μεταβλητών
    private int typeOfFinance; //έσοδο = 1 - έξοδο = -1
    private String descriptionOfFinance;  //περιγραφή της οικονομικής κίνησης
    private double amount;  //ποσό (δαπάνες ή έσοδα)
    DateTime dateOfTransaction; //περιλαμβάνει την ημερομηνία της οικονομικής κίνησης

    //Constructor
    public ProjectFinance(int typeOfFinance, String descriptionOfFinance, double amount,  DateTime dateOfTransaction){
        this.typeOfFinance = typeOfFinance;
        this.descriptionOfFinance = descriptionOfFinance;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
    }

    //Μέθοδος 'getTypeOfFinance()' η οποία επιστρέφει την μεταβλητή typeOfFinance
    public int getTypeOfFinance(){
        return typeOfFinance;
    }

    //Μέθοδος 'getDescriptionOfFinance()' η οποία επιστρέφει την μεταβλητή descriptionOfFinance
    public String getDescriptionOfFinance(){
        return descriptionOfFinance;
    }

    //Μέθοδος 'getAmount()' η οποία επιστρέφει την μεταβλητή amount
    public double getAmount(){
        return amount;
    }

    //Μέθοδος 'getDateOfTransaction()' η οποία επιστρέφει την μεταβλητή dateOfTransaction
    public DateTime getDateOfTransaction(){
        return dateOfTransaction;
    }

}
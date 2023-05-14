import java.util.ArrayList;
import java.util.stream.Collectors;

/*κλάση ProjectDetail για την δημιουργία έργων,
η οποία κληρονομεί απο την ProjectBasic την ονομασία του Project - έργου*/
public class ProjectDetail extends ProjectBasic{
    // Δήλωση μεταβλητών - Στοιχείων για την διεκπεραίωση του έργου
    private String projectDescription;       // Περιγραφή έργου
    private ArrayList <ProjectFinance> transactions = new ArrayList<ProjectFinance>();  /* Δημιουργία δυναμικού πίνακα που θα περιλαμβάνει
    όλες τις οικονομικές κινήσεις (transactions) που αφορούν ένα έργο */

    //Constructor
    public ProjectDetail(String projectName, String projectDescription){
        super(projectName); //κληρονομεί το όνομα του project απο την κλάση (πατέρας) ProjectBasic
        this.projectDescription = projectDescription;
    }

    //Μέθοδος η οποία επιστρέφει ένα String που περιλαμβάνει όλα τα στοιχεία ενός Project
    public String ProjectsToString(){
        return this.getProjectName() + ":" + this.projectDescription;
    }

    //Μέθοδος 'setProjectDescription' η οποία ορίζει την τιμή της μεταβλητής projectDescription
    public void setProjectDescription(String projectDescription){
        this.projectDescription = projectDescription;
    }

    //Μέθοδος 'getProjectDescription()' η οποία επιστρέφει την μεταβλητή projectDescription
    public String getProjectDescription(){
        return projectDescription;
    }

    //Μέθοδος για να περάσουμε ένα έσοδο ή ένα έξοδο (καταγραφή οικονομικής κίνησης)
    public void addTransaction(ProjectFinance f){
        this.transactions.add(f);
    }

    //Μέθοδος που υπολογίζει τα έσοδα του Project (typeOfFinance = 1)
    public double calculateIncome(int year){
        double totalAmount = 0; /*Δημιουργούμε μία πραγματική μεταβλητή totalAmount και την αρχικοποιούμε με μηδέν. Στην συγκεκριμένη μεταβλητή
        θα αποθηκεύουμε - εγχωρούμε τα έσοδα του Project*/

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "transactions.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i=0; i<transactions.size();i++){
            // Αν το είδος συναλλαγης είναι έσοδο και αν το έτος της οικονομικής κίνησης είναι το ίδιο με το έτος που έχουμε ορίσει
            if(transactions.get(i).getTypeOfFinance() == 1 && transactions.get(i).getDateOfTransaction().getYear() == year)
                totalAmount += transactions.get(i).getAmount(); /*τότε εγχωρούμε στην μεταβλητή totalAmount τα έσοδα του Project
                για το συγκεκριμένο έτος */
        }
        return totalAmount; //επιστρέφει τα έσοδα του Project
    }

    //Μέθοδος που υπολογίζει τα έξοδα του Project (typeOfFinance = -1)
    public double calculateExpenses(int year){
        double totalAmount = 0; /*Δημιουργούμε μία πραγματική μεταβλητή totalAmount και την αρχικοποιούμε με μηδέν. Στην συγκεκριμένη μεταβλητή
        θα αποθηκεύουμε - εγχωρούμε τα έξοδα του Project*/

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "transactions.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i=0; i<transactions.size();i++){
            // Αν το είδος συναλλαγης είναι έξοδο και αν το έτος της οικονομικής κίνησης είναι το ίδιο με το έτος που έχουμε ορίσει
            if(transactions.get(i).getTypeOfFinance() == -1 && transactions.get(i).getDateOfTransaction().getYear() == year)
                totalAmount += transactions.get(i).getAmount(); /*Εγχωρούμε στην μεταβλητή totalAmount τα έξοδα του Project
                για το συγκεκριμένο έτος */
        }
        return totalAmount; //επιστρέφει τα έξοδα του Project
    }
}

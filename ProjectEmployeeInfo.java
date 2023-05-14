/* Κλάση ProjectEmployeeInfo για την δημιουργία των έργων που αναλαμβάνει να διεκπεραιώσει ο εργαζόμενος
 * και των ημερομηνιών έναρξης και λήξης του έργου. Αυτή η κλάση κληρονομεί απο την ProjectBasic
 * και έχει επιπλέον 2 πεδία τα οποία αναφέρονται στον εργαζόμενο που έχει εμπλακεί με το Project */
public class ProjectEmployeeInfo extends ProjectBasic {
    // Δήλωση μεταβλητών - Ημερομηνίες έναρξης και λήξης του έργου
    DateTime dateStart;  //ημερομηνία έναρξης των καθηκόντων του εργαζομένου
    DateTime dateEnd;    //ημερομηνία λήξης των καθηκόντων του εργαζομένου

    //Constructor
    public ProjectEmployeeInfo(String projectName, DateTime dateStart, DateTime dateEnd){
        super(projectName);
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    //Μέθοδος 'getProjectName()' η οποία επιστρέφει την μεταβλητή projectName
    public DateTime getDateStart(){
        return dateStart;
    }

    //Μέθοδος 'getProjectName()' η οποία επιστρέφει την μεταβλητή projectName
    public DateTime getDateEnd(){
        return dateEnd;
    }

    //Ορίζει την ημερομηνία που τελειώνει την εμπλοκή του ο εργαζόμενος με το Project
    public void setDateEnd(DateTime dt){
        this.dateEnd = dt;
    }
}

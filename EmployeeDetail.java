import java.util.ArrayList;

/* Κλάση EmployeeDetail για την δημιουργία εργαζομένων,
   η οποία κληρονομεί απο την EmployeeBasic το όνομα και το επίθετο του εργαζομένου */
public class EmployeeDetail extends EmployeeBasic{

    // Δήλωση μεταβλητών - Στοιχείων εργαζομένου
    private DateTime birthDate;          // ημερομηνία γέννησης
    private String maritalStatus;        // Οικογενειακή Κατάσταση
    private int numberOfChildren;        // Αριθμός τέκνων
    private int yearOfRecruitment;       // Έτος πρόσληψης
    private String curDuties;            // Ειδικότητα
    private String levelOfEducation;     // Επίπεδο Σπουδών
    private ArrayList <ProjectEmployeeInfo> workingProjects = new ArrayList<ProjectEmployeeInfo>();    /* Δημιουργία δυναμικού πίνακα - λίστας που δηλώνει
    σε ποιο έργο δουλεύει ο κάθε υπάλληλος */

    //Constructor
    public EmployeeDetail(String firstName, String lastName, DateTime birthDate, String maritalStatus, int numberOfChildren, int yearOfRecruitment,
                          String curDuties, String levelOfEducation){
        super(firstName, lastName);
        this.birthDate = new DateTime(birthDate);

        setMaritalStatus(maritalStatus); /* καλεί την συγκεκριμένη μέθοδο για να εγχωρήσει το κατάλληλο String στην μεταβλητή maritalStatus,
        αναλόγως την οικογενειακή κατάσταση του εργαζομένου */

        this.numberOfChildren = numberOfChildren;
        this.yearOfRecruitment = yearOfRecruitment;
        this.curDuties = curDuties;
        this.levelOfEducation = levelOfEducation;
    }

    //Μέθοδος η οποία επιστρέφει ένα String που περιλαμβάνει όλα τα στοιχεία ενός εργαζομένου
    public String EmployeeToString(){
        return getFirstName() + ":" + getLastName() + ":" + this.birthDate.toString() + ":" + this.maritalStatus + ":" + String.valueOf(numberOfChildren) + ":" +
                String.valueOf(yearOfRecruitment) + ":" + this.curDuties + ":" + this.levelOfEducation;
    }

    //Μέθοδος η οποία επιστρέφει ένα String που περιλαμβάνει όλα τα στοιχεία ενός Project
    public String ProjectsToString(){
        String projectsInfo = "";
        for(int i = 0; i < workingProjects.size(); i++){
            projectsInfo += workingProjects.get(i).getProjectName() + ":" + workingProjects.get(i).dateStart.toString() + ":" + workingProjects.get(i).dateEnd.toString();
            if(i < workingProjects.size()-1){
                projectsInfo += ":";
            }
        }
        if(projectsInfo.length() == 0){
            projectsInfo = "-";
        }
        return projectsInfo;
    }

    //Μέθοδος 'getBirthDate()' η οποία επιστρέφει την μεταβλητή birthDate
    public DateTime getBirthDate() {
        return birthDate;
    }

    //Μέθοδος 'getMaritalStatus()' η οποία επιστρέφει την μεταβλητή maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    //Μέθοδος 'getNumberOfChildren()' η οποία επιστρέφει την μεταβλητή numberOfChildren
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    //Μέθοδος 'getYearOfRecruitment()' η οποία επιστρέφει την μεταβλητή yearOfRecruitment
    public int getYearOfRecruitment() {
        return yearOfRecruitment;
    }

    //Μέθοδος 'getCurDuties()' η οποία επιστρέφει την μεταβλητή curDuties
    public String getCurDuties(){
        return curDuties;
    }

    //Μέθοδος 'getLevelOfEducation()' η οποία επιστρέφει την μεταβλητή levelOfEducation
    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    //Μέθοδος που ελέγχει αν ένας εργαζόμενος είναι έγγαμος ή άγαμος (ορίζει την τιμή της μεταβλητής maritalStatus)
    private void setMaritalStatus(String maritalStatus){
        //ελέγχει αν το maritalStatus είναι "Married" ή "Not Married" αγνοώντας αν οι χαρακτήρες είναι πεζοί ή κεφαλαίοι.
        if(maritalStatus.equalsIgnoreCase("Married"))
            this.maritalStatus = "E";   //Εγχωρεί στην μεταβλητή maritalStatus το "E" που σημαίνει ότι ο εργαζόμενος είναι Έγγαμος
        else if(maritalStatus.equalsIgnoreCase("Not Married"))
            this.maritalStatus = "A";   //Εγχωρεί στην μεταβλητή maritalStatus το "Α" που σημαίνει ότι ο εργαζόμενος είναι Άγαμος
    }

    //Ενημέρωση συγκεκριμένων στοιχείων των εργαζομένων
    public void UpdateEmployeeData(String maritalStatus, int numberOfChildren, String levelOfEducation){
        setMaritalStatus(maritalStatus);  /* καλεί την συγκεκριμένη μέθοδο για να εγχωρήσει το κατάλληλο String στην μεταβλητή maritalStatus,
        αναλόγως την οικογενειακή κατάσταση του εργαζομένου */
        this.numberOfChildren = numberOfChildren;
        this.curDuties = curDuties;
        this.levelOfEducation = levelOfEducation;
    }

    // Μέθοδος η οποία ενημερώνει την ειδικότητα ενός εργαζομένου - αλλάζει την ειδικότητα του
    public void UpdateEmployeeDuties(String curDuties){
        this.curDuties = curDuties;
    }

    //Μέθοδος για τον υπολογισμό του επιδόματος σπουδών ανάλογα την βαθμίδα εκπαίδευσης
    private double CalculateStudyAllowance(){
        double value = 0;  //Δηλώνουμε μία ακέραια μεταβλητή value στην οποία θα εγχωρούμε το ποσό του επιδόματος αναλόγως την βαθμίδα εκπαίδευσης

        /* Ελέγχει αν η μεταβλητή levelOfEducation είναι "University", "Postgraduate" ή "Phd" αγνοώντας αν οι χαρακτήρες είναι πεζοί ή κεφαλαίοι
        και αναλόγως την βαθμίδα εκπαίδευσης εγχωρεί στην μεταβλητή value το αντίστοιχο ποσό */
        if(levelOfEducation.equalsIgnoreCase("University"))
            value = 80;
        else if(levelOfEducation.equalsIgnoreCase("Postgraduate"))
            value = 160;
        else if(levelOfEducation.equalsIgnoreCase("Phd"))
            value = 240;
        return value;  //επιστρέφει την τιμή του επιδόματος αναλόγως την βαθμίδα εκπαίδευσης
    }

    //Μέθοδος για τον υπολογισμό του επιδόματος προϋπηρεσίας ανάλογα με τα χρόνια εργασίας στην εταιρία
    private double CalculateExperienceAllowance(int currentYear){
        //Δηλώνουμε μία ακέραια μεταβλητή countTriple στην οποία θα εγχωρούμε το ποσό του επιδόματος αναλόγως τα χρόνια εργασίας στην εταιρία
        int countTriple = (currentYear - yearOfRecruitment) / 3; // (τωρινή χρονια - ετος προσληψης) / 3

        //κάνει cast σε double την ακέραια μεταβλητή num και επιστρέφει την τιμή της
        return (double)(countTriple * 40); //κάνει cast σε double την ακέραια μεταβλητή countTriple και επιστρέφει την τιμή της επί 40 που είναι το επίδομα προϋπηρεσίας
    }

    //Μέθοδος για τον υπολογισμό του επιδόματος τέκνων
    private double CalculateChildrenAllowance(){
        int num = numberOfChildren; //εγχωρεί στην μεταβλητή num το numberOfChildren (δηλαδή τον αριθμό των τέκνων που εγχώρησε ο χρήστης)
        /* αν ο αριθμος των παιδιων ειναι μεγαλυτερος του 3 τότε στο num εγώρησε τον αριθμό 3 (παιδιά), καθώς το επίδομα ισχύει μέχρι 3 παιδιά.
        Οπότε αν έχει περισσότερα απο 3 τέκνα θα λαμβάνει το επίδομα μόνο για τα 3 από αυτά */
        if(num > 3)
            num = 3;
        return  (double) num*60; /*κάνει cast σε double την ακέραια μεταβλητή num, κατόπιν την πολλαπλασιάζει με 60 που είναι το επίδομα για κάθε παιδί
        και επιστρέφει την τιμή της */
    }

    //Υπολογισμός μηνιαίου μισθού ενός εργαζομένου
    public double CalculateSalary(int currentYear){

        //καλούμε τις μεθόδους που υλοποιήσαμε παραπάνω στην κλάση για τον υπολογισμό του μηνιαίου μισθού ενός εργαζομένου
        double monthlySalary = 750 + CalculateChildrenAllowance() + CalculateStudyAllowance() + CalculateExperienceAllowance(currentYear);

        //Αν η ειδικότητα ενός εργαζομένου είναι "Director" (διευθυντής) τότε πρόσθεσε στον μηνιαίο μισθό του συν 400 ευρώ που είναι το επίδομα θέσης ευθύνης
        if(curDuties.equalsIgnoreCase("Director"))
            monthlySalary += 400;  // monthlySalary = monthlySalary + 400

        return monthlySalary;  // επιστρέφει το μηνιαίο μισθό (monthlySalary) του εργαζομένου
    }

    //Μέθοδος η οποία συνδέει ένα Project με τον εργαζόμενο για συγκεκριμένο χρονικό διάστημα
    public void addProject(String projectName, DateTime dateStart, DateTime dateEnd){
        //Δημιουργία αντικειμένου ProjectEmployeeInfo για την δημιουργία ενός Project
        ProjectEmployeeInfo project = new ProjectEmployeeInfo(projectName, dateStart, dateEnd);
        this.workingProjects.add(project); //Προσθέτει ένα Project
    }
}
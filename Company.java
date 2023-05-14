import java.io.*;
import java.util.ArrayList;

//κλάση Company είναι η κύρια κλάση που περιέχει τους εργαζομένους, τα τμήματα και τα Project
//η διαχείριση όλων των λειτουργιών και οι συσχετίσεις των αντικειμένων υλοποιούνται σε αυτή την κλάση
public class Company {
    private String companyName;  // όνομα της εταιρίας
    private String employeesFile = "Employees.txt";
    private String departmentsFile = "Departments.txt";
    private String projectsFile = "Projects.txt";

    ArrayList <EmployeeDetail> employees = new ArrayList<EmployeeDetail>(); /* Δημιουργία δυναμικού πίνακα - λίστας που θα περιλαμβάνει
    όλους τους εργαζομένους της εταιρίας */
    ArrayList <ProjectDetail> projects = new ArrayList<ProjectDetail>(); /* Δημιουργία δυναμικού πίνακα - λίστας που θα περιλαμβάνει
    όλα τα Project της εταιρίας */
    ArrayList <Department> departments = new ArrayList<Department>(); /* Δημιουργία δυναμικού πίνακα - λίστας που θα περιλαμβάνει
    όλα τα τμήματα της εταιρίας */

    //Constructor
    public Company(String companyName){
        this.companyName = companyName;
    }

    //Μέθοδος για την αναζήτηση (εντοπισμό) ενός συγκεκριμένου εργαζομένου
    private EmployeeDetail findEmployee(String firstName, String lastName){
        if(this.employees.isEmpty()){   //Αν η λίστα είναι άδεια
            return null;                //επέστρεψε το null - 0
        }

        EmployeeDetail e = null; // Δημιουργούμε ένα αντικείμενο e τύπου EmployeeDetail και το αρχικοποιούμε με μηδέν (null)

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "employees.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < employees.size(); i++) {
            // Αν το όνομα και το επίθετο του εργαζομένου στην λίστα είναι το ίδιο με το όνομα και το επίθετο του εργαζομένου που ορίσαμε(ψάχνουμε)
            if (this.employees.get(i).getFirstName().equals(firstName) && this.employees.get(i).getLastName().equals(lastName)) {
                e = this.employees.get(i); //τότε εγχωρούμε στο αντικείμενο e το όνομα και το επίθετο του εργαζομένου
            }
        }
        return e; //επιστρέφει το αντικείμενο e
    }

    //Μέθοδος για την αναζήτηση (εντοπισμό) ενός συγκεκριμένου έργου
    private ProjectDetail findProject(String projectName){
        //Αν η λίστα είναι άδεια επέστρεψε το null - 0
        if(this.projects.isEmpty()){
            return null;
        }

        ProjectDetail p = null; // Δημιουργούμε ένα αντικείμενο p τύπου ProjectDetail και το αρχικοποιούμε με μηδέν (null)

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size(); i++) {
            // Αν το όνομα του Project στην λίστα είναι το ίδιο με το όνομα του Project που ορίσαμε(ψάχνουμε)
            if (this.projects.get(i).getProjectName().equals(projectName)) {
                p = this.projects.get(i); //τότε εγχωρούμε στο αντικείμενο p το όνομα του Project
            }
        }

        return p; //επιστρέφει το αντικείμενο p
    }

    //Μέθοδος για την αναζήτηση (εντοπισμό) ενός συγκεκριμένου τμήματος
    private Department findDepartment(String nameOfDepartment){
        //Αν η λίστα είναι άδεια επέστρεψε το null - 0
        if(this.departments.isEmpty()){
            return null;
        }

        Department d = null; // Δημιουργούμε ένα αντικείμενο d τύπου Department και το αρχικοποιούμε με μηδέν (null)

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "departments.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < departments.size(); i++) {
            // Αν το όνομα του τμήματος στην λίστα είναι το ίδιο με το όνομα του τμήματος που ορίσαμε(ψάχνουμε)
            if (this.departments.get(i).getNameOfDepartment().equals(nameOfDepartment)) {
                d = this.departments.get(i); //τότε εγχωρούμε στο αντικείμενο d το όνομα του τμήματος
            }
        }

        return d; //επιστρέφει το αντικείμενο d
    }

    //Μέθοδος 'getCompanyName()' η οποία επιστρέφει την μεταβλητή companyName
    public String getCompanyName(){
        return this.companyName; //επιστρέφει το όνομα της εταιρίας
    }

    //Μέθοδος η οποία δημιουργεί και προσθέτει αντικείμενα εργαζομένων στην λίστα EmployeeDetail.
    public void addNewEmployee(String firstName, String lastName, DateTime birthDate, String maritalStatus, int numberOfChildren, int yearOfRecruitment,
                               String curDuties, String levelOfEducation){
        employees.add(new EmployeeDetail(firstName,lastName,birthDate,maritalStatus,numberOfChildren,yearOfRecruitment,curDuties,levelOfEducation));
    }

    //Μέθοδος για την εγγραφή ενός εργαζομένου σε κάποιο απο τα τμήματα της εταιρίας
    public boolean registerEmployeeTo(String firstName, String lastName, String nameOfDepartment){
        EmployeeBasic eb = new EmployeeBasic(firstName,lastName); /* Δημιουργία αντικειμένου eb τύπου EmployeeBasic που περιλαμβάνει
        το όνομα και το επίθετο του εργαζομένου */
        Department d = findDepartment(nameOfDepartment); // κανω αναζήτηση του τμηματος με βαση το όνομα του

        /* Εάν το αντικείμενο d ειναι μηδέν τότε επέστρεψε false. Δηλαδή, αν δεν υπάρχει το όνομα του τμήματος που κάνουμε
        αναζήτηση στην λίστα departments τοτε επέστρεψε false */
        if(d == null)
            return false;

        if(d.isEmployeeInList(eb)) //Αν το όνομα και το επίθετο του εργαζομένου είναι στην λίστα "isEmployeeInList"
            d.RegisterEmployee(eb); //τότε εγχώρησε τον εργαζόμενο στο τμήμα που ορίσαμε (εγγραφή του εργαζομένου στο τμήμα)
        return true; //επέστρεψε true
    }

    //Μέθοδος για την απεγγραφή ενός εργαζομένου απο κάποιο τμήμα της εταιρίας στο οποίο ανήκει
    public boolean unregisterEmployeeFromDept(String firstName, String lastName,String nameOfDepartment){
        EmployeeBasic eb = new EmployeeBasic(firstName,lastName);/* Δημιουργία αντικειμένου eb τύπου EmployeeBasic που περιλαμβάνει
        το όνομα και το επίθετο του εργαζομένου */
        Department d = findDepartment(nameOfDepartment); //κανω αναζήτηση του τμηματος με βαση το όνομα του

        /* Εάν το αντικείμενο d ειναι μηδέν τότε επέστρεψε false. Δηλαδή, αν δεν υπάρχει το όνομα του τμήματος που κάνουμε
        αναζήτηση στην λίστα departments τοτε επέστρεψε false */
        if(d == null)
            return false;

        if(d.isEmployeeInList(eb)) //Αν το όνομα και το επίθετο του εργαζομένου είναι στην λίστα "isEmployeeInList"
            d.deleteEmployee(eb); // τότε διέγραψε τον εργαζόμενο απο το τμήμα που ορίσαμε
        return true; //επέστρεψε true
    }

    //Μέθοδος η οποία ενημερώνει συγκεκριμένα στοιχεία των εργαζομένων
    public void updateEmployeeData(String firstName, String lastName, String maritalStatus, int numberOfChildren, String levelOfEducation){
        EmployeeDetail ed = findEmployee(firstName, lastName); //κανω αναζήτηση του εργαζομένου με βαση το όνομα και το επίθετο του
        ed.UpdateEmployeeData(maritalStatus,numberOfChildren,levelOfEducation); /* καλούμε την μέθοδο "UpdateEmployeeData" της κλάσης EmployeeDetail
        και ενημερώνουμε την οικογενειακή κατάσταση, τον αριθμό παιδιών και το επίπεδο σπουδών ενός εργαζομένου*/
    }

    //Μέθοδος για την μετακίνηση εργαζομένων απο ένα τμήμα σε ένα άλλο
    public boolean moveEmployeeBetweenDepts(String firstName, String lastName, String nameOfDepartmentFrom, String nameOfDepartmentTo){
        //Τμήμα απο το οποίο θα φύγει ο εργαζόμενος
        Department dFrom = findDepartment(nameOfDepartmentFrom); //κανω αναζήτηση του τμηματος με βαση το όνομα του
        //Τμήμα στο οποίο θα πάει ο εργαζόμενος
        Department dTo = findDepartment(nameOfDepartmentTo); //κανω αναζήτηση του τμηματος με βαση το όνομα του

        // Εάν τα αντικείμενα dFrom και dTo ειναι διάφορα του μηδενός
        if(dFrom != null && dTo != null){
            unregisterEmployeeFromDept(firstName,lastName,nameOfDepartmentFrom); //Απεγγραφή του εργαζομένου (που ορίσαμε) απο το τμήμα της εταιρίας (που ορίσαμε)
            registerEmployeeTo(firstName,lastName,nameOfDepartmentTo); //Εγγραφή του εργαζομένου στο νέο τμήμα της εταιρίας
            return true; // επέστρεψε true
        }
        return false; // επέστρεψε false
    }

    //Μέθοδος για την ανάθεση ενός εργαζομένου σε ένα απο τα Project της εταιρίας
    public void assignEmployeeToProject(String firstName, String lastName, String projectName, DateTime dateStart, DateTime dateEnd){
        EmployeeDetail ed = findEmployee(firstName, lastName); //κανω αναζήτηση του εργαζομένου με βαση το όνομα και το επίθετο του
        ed.addProject(projectName,dateStart,dateEnd); /* Καλώ την μέθοδο "addProject" της κλάσης EmployeeDetail για την ανάθεση
        ενός έργου στον εργαζόμενο για συγκεκριμένο χρονικό διάστημα */
    }

    //Μέθοδος η οποία δημιουργεί και προσθέτει αντικείμενα τμημάτων στη λίστα Department.
    public void addNewDepartment(String nameOfDepartment, String descriptionOfDepartment){
        departments.add(new Department(nameOfDepartment,descriptionOfDepartment));
    }

    //Μέθοδος για την ανάθεση νέου διευθυντή σε κάποιο απο τα τμήματα της εταιρίας
    public void assignNewDirectorToDept(String firstName, String lastName,String nameOfDepartment, DateTime dutiesStart){
        Department d = findDepartment(nameOfDepartment); //κανω αναζήτηση του τμηματος με βαση το όνομα του
        d.RegisterDirector(firstName,lastName,dutiesStart); // Εγγραφή νέου διευθυντή στο τμήμα της εταιρίας που ορίσαμε (αντικατάσταση διευθυντή)
        EmployeeDetail ed = findEmployee(firstName, lastName); //κανω αναζήτηση του εργαζομένου με βαση το όνομα και το επίθετο του
        ed.UpdateEmployeeDuties("Director"); /* Καλώ την μέθοδο "UpdateEmployeeDuties" της κλάσης EmployeeDetail για την
        ενημέρωση της ειδικότητας ενός εργαζομένου σε διευθυντή - Director */
    }

    //Μέθοδος η οποία δημιουργεί και προσθέτει αντικείμενα έργων στην λίστα ProjectDetail.
    public void addNewProject(String projectName, String projectDescription){
        projects.add(new ProjectDetail(projectName, projectDescription));
    }

    //Μέθοδος για την προσθήκη εσόδου σε κάποιο απο τα Project της εταιρίας
    public boolean addNewIncomeToProject(String projectName,  String descriptionOfFinance, double amount,  DateTime dateOfTransaction) {
        ProjectDetail p = findProject(projectName); //κανω αναζήτηση του Project με βαση το όνομα του

        /* Εάν το αντικείμενο p ειναι διάφορο του μηδενός τότε επέστρεψε true. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το Project) τότε να προσθέσει
         την οικονομική κίνηση - transaction */
        if(p != null){
            p.addTransaction(new ProjectFinance(1,descriptionOfFinance,amount,dateOfTransaction)); /* Προσθήκη ενός εσόδου (οικονομική κίνηση) */
            return true; //επέστρεψε true
        }
        return false; //επέστρεψε false
    }

    //Μέθοδος για την προσθήκη εξόδου σε κάποιο απο τα Project της εταιρίας
    public boolean addNewExpenseToProject(String projectName,  String descriptionOfFinance, double amount,  DateTime dateOfTransaction) {
        ProjectDetail p = findProject(projectName); //κανω αναζήτηση του Project με βαση το όνομα του

        /* Εάν το αντικείμενο p ειναι διάφορο του μηδενός τότε επέστρεψε true. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το Project) τότε να προσθέσει
         την οικονομική κίνηση - transaction */
        if(p != null){
            p.addTransaction(new ProjectFinance(-1,descriptionOfFinance,amount,dateOfTransaction)); /* Προσθήκη ενός εξόδου (οικονομική κίνηση) */
            return true; //επέστρεψε true
        }
        return false; //επέστρεψε false
    }

    //Μέθοδος για τον υπολογισμό των εσόδων ενός Project για συγκεκριμένο έτος
    public double calculateIncomeForProject(String projectName, int year){
        ProjectDetail p = findProject(projectName); //κανω αναζήτηση του Project με βαση το όνομα του

        double income = 0; // Δημιουργούμε μία double μεταβλητή income για την εγχώρηση των εσόδων του Project για ένα συγκεκριμένο έτος

        if(p != null){                              //Εάν το αντικείμενο p ειναι διάφορο του μηδενός. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το Project)
            income = p.calculateIncome(year);       //τότε να εγχωρήσει στην μεταβλητή income τα ετήσια έσοδα του συγκεκριμένου Project
        }
        return income; //επιστρέφει τα ετήσια έσοδα
    }

    //Μέθοδος για τον υπολογισμό των εξόδων ενός Project για συγκεκριμένο έτος
    public double calculateExpensesForProject(String projectName, int year){
        ProjectDetail p = findProject(projectName); //κανω αναζήτηση του Project με βαση το όνομα του

        double expense = 0; // Δημιουργούμε μία double μεταβλητή expense για την εγχώρηση των εξόδων του Project για ένα συγκεκριμένο έτος

        if(p != null){                               //Εάν το αντικείμενο p ειναι διάφορο του μηδενός. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το Project)
            expense = p.calculateExpenses(year);     //τότε να εγχωρήσει στην μεταβλητή expense τα ετήσια έξοδα του συγκεκριμένου Project
        }
        return expense; //επιστρέφει τα ετήσια έξοδα
    }

    //Μέθοδος για τον υπολογισμό των εσόδων όλων των Project για συγκεκριμένο έτος
    public double calculateIncomeFromAllProjects(int year){
        double total = 0; // Δημιουργούμε μία double μεταβλητή total για την εγχώρηση των εσόδων όλων των Project για ένα συγκεκριμένο έτος

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size();i++){
            total += projects.get(i).calculateIncome(year); //Εγχωρεί στην μεταβλητή total τα ετήσια έσοδα του κάθε Project
        }
        return total; //επιστρέφει τα ετήσια έσοδα για όλα τα Project
    }

    //Μέθοδος για τον υπολογισμό των εξόδων όλων των Project για συγκεκριμένο έτος
    public double calculateExpensesFromAllProjects(int year){
        double total = 0; // Δημιουργούμε μία double μεταβλητή total για την εγχώρηση των εξόδων όλων των Project για ένα συγκεκριμένο έτος

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size();i++){
            total += projects.get(i).calculateExpenses(year); //Εγχωρεί στην μεταβλητή total τα ετήσια έξοδα του κάθε Project
        }
        return total; //επιστρέφει τα ετήσια έξοδα για όλα τα Project
    }

    //Μέθοδος για τον υπολογισμό του μηνιαίου μισθού ενός εργαζομένου
    public double calculateMonthlySalaryForEmployee(String firstName, String lastName, int year){
        EmployeeDetail ed = findEmployee(firstName,lastName); //κανω αναζήτηση του εργαζομένου με βαση το όνομα και το επίθετο του
        return (ed == null) ? -1 : ed.CalculateSalary(year); /* Εάν το αντικείμενο ed ειναι ίσο με το μηδέν. Δηλαδή, αν η αναζήτηση είναι αποτυχής (δηλαδή δεν υπάρχει ο εργαζόμενος)
        τότε επέστρεψε -1. Αλλιώς αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει ο εργαζόμενος) τότε επέστρεψε τον μηνιαίο του μισθό */
    }

    //Μέθοδος για τον υπολογισμό του ετήσιου μισθού όλων των εργαζομένων
    public double calculateAnnualSalariesOfAllEmployees(int year){
        double salaries = 0; // Δημιουργούμε μία double μεταβλητή salaries για την εγχώρηση των μισθών όλων των εργαζομένων για ένα συγκεκριμένο έτος

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "employees.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0;i < employees.size();i++){
            salaries += employees.get(i).CalculateSalary(year); //Εγχωρεί στην μεταβλητή salaries τους ετήσιους μισθούς όλων των εργαζομένων για συγκεκριμένο έτος
        }
        return salaries * 12; // επιστρέφει τους μισθούς για 12 μήνες
    }

    //Μέθοδος για τον υπολογισμό των εσόδων της εταιρίας στην διάρκεια ενός έτους
    public double calculateAnnualCompanyIncome(int year){
        double totalIncome = 0; // Δημιουργούμε μία double μεταβλητή totalIncome για την εγχώρηση των εσόδων της εταιρίας για ένα συγκεκριμένο έτος

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size();i++){
            totalIncome += projects.get(i).calculateIncome(year); //Εγχωρεί στην μεταβλητή totalIncome τα ετήσια έσοδα της εταιρίας
        }

        return totalIncome; //επιστρέφει τα ετήσια έσοδα της εταιρίας
    }

    //Μέθοδος για τον υπολογισμό των εξόδων της εταιρίας στην διάρκεια ενός έτους
    public double calculateAnnualCompanyExpenses(int year){
        double totalExpenses = 0; // Δημιουργούμε μία double μεταβλητή totalExpenses για την εγχώρηση των εξόδων της εταιρίας για ένα συγκεκριμένο έτος

        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size();i++){
            totalExpenses += projects.get(i).calculateExpenses(year); //Εγχωρεί στην μεταβλητή totalExpenses τα ετήσια έξοδα της εταιρίας
        }

        return totalExpenses; //επιστρέφει τα ετήσια έξοδα της εταιρίας
    }

    //Μέθοδος για την εμφάνιση όλων των τμημάτων της εταιρίας
    public void printAllDepartments(){
        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "departments.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < departments.size();i++){
            //Εκτυπώνει το όνομα και την περιγραφή του κάθε τμήματος
            System.out.println(departments.get(i).getNameOfDepartment() + " " + departments.get(i).getDescriptionOfDepartment());
        }
    }

    //Μέθοδος για την εμφάνιση όλων των Project της εταιρίας
    public void printAllProjects(){
        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "projects.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < projects.size();i++){
            //Εκτυπώνει το όνομα και την περιγραφή του κάθε Project
            System.out.println(projects.get(i).getProjectName() + " " + projects.get(i).getProjectDescription());
        }
    }

    //Μέθοδος για την εμφάνιση όλων των εργαζομομένων της εταιρίας
    public void printAllEmployees(){
        //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "employees.size()" εκτέλεσε το περιεχόμενο του βρόγχου for
        for(int i = 0; i < employees.size();i++){
            //Εκτυπώνει το όνομα, το επίθετο και την ειδικότητα του κάθε εργαζομένου
            System.out.println(employees.get(i).getFirstName() + " " + employees.get(i).getLastName() + " - " + employees.get(i).getCurDuties());
        }
    }

    //Μέθοδος για την εμφάνιση του διευθυντή που ανήκει σε ένα συγκεκριμένο τμήμα της εταιρίας
    public void printDirectorFromDept(String nameOfDepartment){
        Department dept = findDepartment(nameOfDepartment); //κανω αναζήτηση του τμηματος με βαση το όνομα του

        if(dept == null) {
            System.out.println("The name: " + nameOfDepartment + " " + "does not exist");
            return;
        }

        Director d = dept.getDirector(); //επιστρέφει τον Director του τμήματος "nameOfDepartment"

        /* Εάν το αντικείμενο d ειναι διάφορο του μηδενός. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το τμήμα) τότε να εκτελέσει
        το περιεχόμενο της if. */
        if(d != null){
            //Εκτυπώνει το όνομα, το επίθετο και την ημερομηνία έναρξης των καθηκόντων του
            System.out.println("The director of " + nameOfDepartment + " is " + d.getFirstName() + " " + d.getLastName() + ". He is started duties from " + d.getDutiesStart().toString());
        }
        else
            System.out.println("Director not assigned");
    }

    //Μέθοδος για την εμφάνιση όλων των εργαζομένων που ανήκουν σε ένα συγκεκριμένο τμήμα της εταιρίας
    public void printEmployeesFromDept(String nameOfDepartment){
        Department d = findDepartment(nameOfDepartment);  //κανω αναζήτηση του τμηματος με βαση το όνομα του

        /* Εάν το αντικείμενο d ειναι διάφορο του μηδενός. Δηλαδή, αν η αναζήτηση είναι επιτυχής (δηλαδή υπάρχει το τμήμα) τότε να εκτελέσει
        το περιεχόμενο της if. */
        if(d != null){
            //Όσο η ακέραια μεταβλητή i είναι μικρότερη του μεγέθους της λίστας "d.getEmployees().size()" εκτέλεσε το περιεχόμενο του βρόγχου for
            for(int i = 0; i < d.getEmployees().size();i++){
                //Εκτυπώνει το όνομα και το επίθετο του εργαζομένου
                System.out.println(d.getEmployees().get(i).getFirstName() + " " + d.getEmployees().get(i).getLastName());
            }
        }
    }

    //Μέθοδος που επιστρέφει την λίστα των εργαζομένων
    public ArrayList<EmployeeDetail> getEmployees(){
        return employees;
    }

    //Μέθοδος που επιστρέφει την λίστα των τμημάτων
    public ArrayList<Department> getDepartments(){
        return departments;
    }

    //Μέθοδος που επιστρέφει την λίστα των Projects
    public ArrayList<ProjectDetail> getProjects(){
        return projects;
    }


    //Μέθοδος για την ανάγνωση ενός
    private BufferedReader getReader(String fileName){
        BufferedReader in = null;

        try
        {
            File file = new File(fileName);
            in = new BufferedReader(
                    new FileReader(file) );
        }

        catch (FileNotFoundException e)
        {
            System.out.println("The file doesn't exist.");
            System.exit(0);
        }

        return in;
    }

    private PrintWriter openWriter(String fileName){
        try
        {
            File file = new File(fileName);
            PrintWriter out =
                    new PrintWriter(
                            new BufferedWriter(
                                    new FileWriter(file) ), true );
            return out;
        }
        catch (IOException e)
        {
            System.out.println("I/O Error");
            System.exit(0);
        }
        return null;
    }

    public void saveEmployeesToFile(){
        PrintWriter out = openWriter(employeesFile);

        for(EmployeeDetail e : employees){
            out.println(e.EmployeeToString());
            out.println(e.ProjectsToString());
        }
    }

    public void loadEmployeesFromFile(){
        employees = new ArrayList<>();
        BufferedReader in = getReader(employeesFile);
        EmployeeDetail e = readEmployee(in);

        while(e != null){
            employees.add(e);
            e = readEmployee(in);
        }
    }

    private EmployeeDetail readEmployee(BufferedReader in){
        String line1 = "";
        String line2 = "";
        String[] data1;
        String[] data2;

        try
        {
            line1 = in.readLine();
        }
        catch (IOException e)
        {
            System.out.println("I/O Error");
            System.exit(0);
        }

        try
        {
            line2 = in.readLine();
        }
        catch (IOException e)
        {
            System.out.println("I/O Error");
            System.exit(0);
        }

        if (line1 == null)
            return null;
        else
        {
            data1 = line1.split(":");
            EmployeeDetail e = new EmployeeDetail(data1[0], data1[1], new DateTime(data1[2]),data1[3], Integer.parseInt(data1[4]),Integer.parseInt(data1[4]),
                    data1[5], data1[6]);

            if(line2 != null){
                if(!line2.equals("-")){
                    data2 = line2.split((":"));

                    for(int i = 0; i < data2.length; i += 3){
                        ProjectEmployeeInfo p = new ProjectEmployeeInfo(data2[i], new DateTime(data2[i+1]), new DateTime(data2[i+2]));
                        e.addProject(data2[i], new DateTime(data2[i+1]), new DateTime(data2[i+2]));
                    }
                }
            }
            return e;
        }
    }

    public void saveDepartmentsToFile(){
        PrintWriter out = openWriter(departmentsFile);

        for(Department d : departments){
            out.println(d.DepartmentToString());
        }
    }

    public void loadDepartmentsFromFile(){
        departments = new ArrayList<>();
        BufferedReader in = getReader(departmentsFile);
        Department d = readDepartment(in);

        while(d != null){
            departments.add(d);
            d = readDepartment(in);
        }
    }

    private Department readDepartment(BufferedReader in){
        String line1 = "";
        String[] data1;

        try
        {
            line1 = in.readLine();
        }

        catch (IOException e)
        {
            System.out.println("I/O Error");
            System.exit(0);
        }

        if (line1 == null)
            return null;
        else
        {
            data1 = line1.split(":");
            Department d = new Department(data1[0], data1[1]);
            return d;
        }
    }

    public void saveProjectsToFile(){
        PrintWriter out = openWriter(projectsFile);

        for(ProjectDetail p : projects){
            out.println(p.ProjectsToString());
        }
    }

    public void loadProjectsFromFile(){
        projects = new ArrayList<>();
        BufferedReader in = getReader(projectsFile);
        ProjectDetail p = readProject(in);

        while(p != null){
            projects.add(p);
            p = readProject(in);
        }
    }

    private ProjectDetail readProject(BufferedReader in) {
        String line1 = "";
        String[] data1;

        try {
            line1 = in.readLine();
        } catch (IOException e) {
            System.out.println("I/O Error");
            System.exit(0);
        }

        if (line1 == null)
            return null;
        else {
            data1 = line1.split(":");
            ProjectDetail p = new ProjectDetail(data1[0], data1[1]);
            return p;
        }
    }

        //Μέθοδος η οποία αποθηκεύει όλα τα αρχεία που δημιουργήσαμε
        public void saveAllFiles(){
            saveEmployeesToFile();
            saveDepartmentsToFile();
            saveProjectsToFile();
        }

        public void loadAllFiles(){
            loadEmployeesFromFile();
            loadDepartmentsFromFile();
            loadProjectsFromFile();
        }
    }
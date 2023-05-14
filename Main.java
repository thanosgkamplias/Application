/*
3212019029, Γκαμπλιάς Αθανάσιος
 */

// Κλάση Main στην οποία καλούμε όλες μεθόδους που υλοποιήσαμε στην κλάση Company
public class Main {
    public static void main(String[] args) {
        //for testing purpose we load testing data that save to files
        testClassAndMethods();

        //Δημιουργία αντικειμένου Gui για την έναρξη της γραφικής διεπαφής
        Gui g = new Gui();
    }
    private static void testClassAndMethods(){
        Company c = new Company("Corporaze Company");
        System.out.println(c.getCompanyName());

        //Δημιουργία 3 τμημάτων της εταιρίας
        System.out.println("---------------------------------------------");
        System.out.println("Adding three departments: ");
        c.addNewDepartment("Marketing", "Promotes your business and drives sales of its products or services");
        c.addNewDepartment("Accounting", "is responsible for preparing the financial statements");
        c.addNewDepartment("Engineering", "provides technical, engineering, surveying and hands on support on capital improvement projects");
        c.printAllDepartments();  //Εκτυπώνει όλα τα τμήματα της εταιρίας

        //Δημιουργία 2 έργων
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Adding two Projects: ");
        c.addNewProject("Aegean Motorway", "Construction of a highway");
        c.addNewProject("AEL FC ARENA", "Construction of a football stadium");
        c.printAllProjects();  //Εκτυπώνει όλα τα Projects της εταιρίας

        //Δημιουργία 5 εργαζομένων
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Adding five employees: ");
        c.addNewEmployee("Thanos", "Gablias", new DateTime(2001,3,17),"Not Married", 0, 2, "ICTs", "University");
        c.addNewEmployee("Nikos", "Pappas",  new DateTime(1992,8,14), "Married", 2, 10, "Mechanical Engineering", "Phd");
        c.addNewEmployee("Giorgos", "Anastasiadhs",  new DateTime(1983,5,8), "Married", 4, 18, "Manager", "Phd");
        c.addNewEmployee("Dimitra", "Anagnostou",  new DateTime(1995,10,19), "Married", 0, 7, "ICTs", "Postgraduate");
        c.addNewEmployee("Stefanos", "Antoniadis",  new DateTime(1998,2,28), "Not Married", 0, 5, "Civil Engineering", "University");
        //Ενημέρωση συγκεκριμένων στοιχείων ενός εργαζομένου (ενημερώσαμε τον αριθμό των παιδιών)
        c.updateEmployeeData("Dimitra", "Anagnostou", "Married", 1, "Postgraduate");
        //Ενημέρωση συγκεκριμένων στοιχείων ενός εργαζομένου (ενημερώσαμε την οικογενειακή κατάσταση)
        c.updateEmployeeData("Giorgos", "Anastasiadhs", "Not Married", 4, "Phd");
        c.printAllEmployees(); //Εκτυπώνει όλους τους εργαζομένους της εταιρίας


        //Εγγραφή των εργαζομένων σε τμήματα της εταιρίας
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Register employees to department");
        c.registerEmployeeTo("Thanos", "Gablias", "Accounting");
        c.registerEmployeeTo("Nikos", "Pappas", "Engineering");
        c.registerEmployeeTo("Giorgos", "Anastasiadhs", "Accounting");
        c.registerEmployeeTo("Dimitra", "Anagnostou", "Engineering");
        c.registerEmployeeTo("Stefanos", "Antoniadis", "Marketing");
        c.printEmployeesFromDept("Accounting"); //Εκτυπώνει τους εργαζομένους που ανήκουν στο τμήμα Accounting
        c.printEmployeesFromDept("Engineering"); //Εκτυπώνει τους εργαζομένους που ανήκουν στο τμήμα Engineering
        c.printEmployeesFromDept("Marketing"); //Εκτυπώνει τους εργαζομένους που ανήκουν στο τμήμα Marketing

        //Εγγραφή των εργαζομένων στα Project της εταιρίας
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Register employees to projects: ");
        c.assignEmployeeToProject("Thanos", "Gablias", "Aegean Motorway",  new DateTime(2019,3,8),  new DateTime(2020,9,4));
        c.assignEmployeeToProject("Nikos", "Pappas", "AEL FC ARENA",  new DateTime(2019,2,11),  new DateTime(2020,5,17));
        c.assignEmployeeToProject("Giorgos", "Anastasiadhs", "Aegean Motorway", new DateTime(2019,7,17), new DateTime(2020,10,23));
        c.assignEmployeeToProject("Dimitra", "Anagnostou", "AEL FC ARENA", new DateTime(2019,8,7), new DateTime(2020,11,5));
        c.assignEmployeeToProject("Stefanos", "Antoniadis", "Aegean Motorway", new DateTime(2019,1,13), new DateTime(2020,4,29));

        //Μετακίνηση ενός υπαλλήλου απο το τμήμα που βρίσκεται σε ένα άλλο
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Moving employee between departments");
        c.moveEmployeeBetweenDepts("Thanos", "Gablias", "Accounting", "Marketing");
        c.printEmployeesFromDept("Accounting");
        c.printEmployeesFromDept("Marketing");

        //Ανάθεση σε άλλον εργαζόνενο την διεύθυνση του τμήματος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Change director");
        c.assignNewDirectorToDept("Thanos", "Gablias", "Marketing", new DateTime(2020,1,13));
        c.assignNewDirectorToDept("Giorgos", "Anastasiadhs", "Accounting", new DateTime(2020,1,16));
        c.assignNewDirectorToDept("Nikos", "Pappas", "Engineering", new DateTime(2020,1,24));
        //Εμφάνιση των διευθυντων των τμημάτων
        c.printDirectorFromDept("Marketing");
        c.printDirectorFromDept("Accounting");
        c.printDirectorFromDept("Engineering");

        //Πρόσθεση ποσού (έξοδο) σε κάποιο απο τα Projects
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Adding expenses to project: ");
        c.addNewExpenseToProject("Aegean Motorway", "iron", 3875.64, new DateTime(2019,4,13));
        c.addNewExpenseToProject("AEL FC ARENA", "plastic seat", 1875.32, new DateTime(2020,2,2));
        c.addNewExpenseToProject("Aegean Motorway", "tar", 6500.07, new DateTime(2020,2,8));

        //Πρόσθεση ποσού (έσοδο) σε κάποιο απο τα Projects
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Adding income to project: ");
        c.addNewIncomeToProject("Aegean Motorway", "Payments from E1 company", 8500, new DateTime(2019, 8, 19));
        c.addNewIncomeToProject("AEL FC ARENA", "Payments from A4 company", 16000, new DateTime(2019,2,8));
        c.addNewIncomeToProject("Aegean Motorway", "Payments from B94 company", 6800, new DateTime(2020,5,8));
        c.addNewIncomeToProject("AEL FC ARENA", "Payments from D873 company", 21000, new DateTime(2020,2,8));

        //Εμφάνιση των εσόδων ενός Project για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Calculate income for project Aegean Motorway 2019: " + c.calculateIncomeForProject("Aegean Motorway", 2019));
        System.out.println("Calculate income for project AEL FC ARENA 2020: " + c.calculateIncomeForProject("AEL FC ARENA", 2020));
        System.out.println("Calculate income for project Aegean Motorway 2020: " + c.calculateIncomeForProject("Aegean Motorway", 2020));
        System.out.println("Calculate income for project AEL FC ARENA 2020: " + c.calculateIncomeForProject("AEL FC ARENA", 2020));

        //Εμφάνιση των εξόδων ενός Project για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Calculate income for project Aegean Motorway 2020: " + c.calculateExpensesForProject("Aegean Motorway", 2020));
        System.out.println("Calculate income for project AEL FC ARENA 2020: " + c.calculateExpensesForProject("AEL FC ARENA", 2020));

        //Εμφάνιση των εξόδων όλων των Projects για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Total expenses from all projects (2020): " + c.calculateExpensesFromAllProjects(2020));
        System.out.println("Total expenses from all projects (2019): " + c.calculateExpensesFromAllProjects(2019));

        //Εμφάνιση των εσόδων όλων των Projects για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Total income from all projects (2020): " + c.calculateIncomeFromAllProjects(2020));
        System.out.println("Total income from all projects (2019): " + c.calculateIncomeFromAllProjects(2019));

        //Εμφάνιση μηνιαίου μισθού ενός εργαζομένου
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Monthly salary for Thanos Gablias (2020): " + c.calculateMonthlySalaryForEmployee("Thanos", "Gablias", 2020));
        System.out.println("Monthly salary for Giorgos Anastasiadhs (2020): " + c.calculateMonthlySalaryForEmployee("Giorgos", "Anastasiadhs", 2020));

        //Εμφάνιση όλων των εσόδων της εταιρίας για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Annual income of year 2019: " + c.calculateAnnualCompanyIncome(2019));
        System.out.println("Annual income of year 2020: " + c.calculateAnnualCompanyIncome(2020));

        //Εμφάνιση όλων των εξόδων της εταιρίας για συγκεκριμένο έτος
        System.out.println(" ");
        System.out.println("---------------------------------------------");
        System.out.println("Annual expenses of year 2019: " + c.calculateAnnualCompanyExpenses(2019));
        System.out.println("Annual expenses of year 2020: " + c.calculateAnnualCompanyExpenses(2020));
        
        c.saveAllFiles();
    }
}


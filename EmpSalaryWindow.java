import javax.swing.*;
import java.awt.*;

//Κλάση για την εμφάνιση των συνολικών μηνιαίων μισθών ενός υπαλλήλου για συγκεκριμένο έτος μέσω γραφικής διεπαφής
public class EmpSalaryWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    Company company; //περέχει όλα τα δεδομένα του object company

    EmpSalaryWindow(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
        frame.setSize(1080,720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος
        panel = new JPanel(); //Δημιουργία νέου JPanel

        //Πίνακας που έχει τους τίτλους των πεδίων της κλάσης EmployeeDetail
        String [] colNames = {"First Name", "Last Name","Salary"};

        //Δημιουργία δισδιάστατου πίνακα που θα χρησιμοποιηθεί για την απεικόνιση των δεδομένων της ArrayList <EmployeeDetail>
        String [][] dataVal = new String [c.getEmployees().size()][2];

        for(int i = 0; i < c.getEmployees().size(); i++){
            //ενημέρωση γραμμής με τα στοιχεία του employee
            dataVal[i][0] = String.valueOf(c.calculateMonthlySalaryForEmployee(c.getEmployees().get(i).getFirstName(),c.getEmployees().get(i).getLastName(),2020));
            dataVal[i][1] = String.valueOf(c.calculateMonthlySalaryForEmployee(c.getEmployees().get(i).getFirstName(),c.getEmployees().get(i).getLastName(),2019));
        }

        //Δημιουργία του table από το Array που περιέχει τους τίτλους και το Array που περιέχει όλα τα δεδομένα
        table = new JTable(dataVal,colNames);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); //Auto resize των στηλών του πίνακα για να απεικονίζονται όλα τα δεδομένα
        table.setPreferredScrollableViewportSize(new Dimension(1000, 700)); //οι διαστάσεις του πίνακα

        scrollPane = new JScrollPane(table); //μας βοηθάει να κάνει scroll όταν δεν μπορούν να εμγανιστούν στην οθόνη όλα τα δεδομένα του table

        panel.add(scrollPane);
        frame.add(panel);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό
    }
}

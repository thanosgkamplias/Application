import javax.swing.*;
import java.awt.*;

//Κλάση για την εμφάνιση όλων των υπαλλήλων της εταιρίας μέσω γραφικής διεπαφής
public class PrintEmpWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    private Company company; //περέχει όλα τα δεδομένα του object company

    PrintEmpWindow(Company c){   //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
        frame.setSize(1080,720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος

        panel = new JPanel(); //Δημιουργία νέου JPanel

        //Πίνακας που έχει τους τίτλους των πεδίων της κλάσης EmployeeDetail
        String [] colNames = {"First Name", "Last Name", "Birth Date", "Marital Status", "Number of Children", "Year of recruitment", "Duties", "Level of education"};
        //Δημιουργία δισδιάστατου πίνακα που θα χρησιμοποιηθεί για την απεικόνιση των δεδομένων της ArrayList <EmployeeDetail>
        String [][] dataVal = new String [c.getEmployees().size()][8];

        for(int i = 0; i < c.getEmployees().size(); i++){
            //ενημέρωση γραμμής με τα στοιχεία του Employee
            dataVal [i][0] = c.getEmployees().get(i).getFirstName();
            dataVal[i][1] = c.getEmployees().get(i).getLastName();
            dataVal[i][2] = c.getEmployees().get(i).getBirthDate().toString();
            dataVal[i][3] = c.getEmployees().get(i).getMaritalStatus();
            dataVal[i][4] = String.valueOf(c.getEmployees().get(i).getNumberOfChildren());
            dataVal[i][5] = String.valueOf(c.getEmployees().get(i).getYearOfRecruitment());
            dataVal[i][6] = c.getEmployees().get(i).getCurDuties();
            dataVal[i][7] = c.getEmployees().get(i).getLevelOfEducation();
        }

        //Δημιουργία του table από το Array που περιέχει τους τίτλους και το Array που περιέχει όλα τα δεδομένα
        table = new JTable(dataVal,colNames);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);    //Auto resize των στηλών του πίνακα για να απεικονίζονται όλα τα δεδομένα
        table.setPreferredScrollableViewportSize(new Dimension(1000, 700));   //οι διαστάσεις του πίνακα

        scrollPane = new JScrollPane(table); //μας βοηθάει να κάνει scroll όταν δεν μπορούν να εμγανιστούν στην οθόνη όλα τα δεδομένα του table

        panel.add(scrollPane);
        frame.add(panel);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό
    }
}
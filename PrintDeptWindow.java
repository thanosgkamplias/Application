import javax.swing.*;
import java.awt.*;

//Κλάση για την εμφάνιση όλων των τμημάτων της εταιρίας μέσω γραφικής διεπαφής
public class PrintDeptWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    Company company; //περέχει όλα τα δεδομένα του object company

    PrintDeptWindow(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
        frame.setSize(1080,720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος
        panel = new JPanel(); //Δημιουργία νέου JPanel

        //Πίνακας που έχει τους τίτλους των πεδίων της κλάσης Department
        String [] colNames = {"Name of the Department", "Description"};

        //Δημιουργία δισδιάστατου πίνακα που θα χρησιμοποιηθεί για την απεικόνιση των δεδομένων της ArrayList <Department>
        String [][] dataVal = new String [c.getDepartments().size()][2];

        for(int i = 0; i < c.getDepartments().size(); i++){
            //ενημέρωση γραμμής με τα στοιχεία του Department
            dataVal [i][0] = c.getDepartments().get(i).getNameOfDepartment();
            dataVal[i][1] = c.getDepartments().get(i).getDescriptionOfDepartment();
        }

        //Δημιουργία του table από το Array που περιέχει τους τίτλους και το Array που περιέχει όλα τα δεδομένα
        table = new JTable(dataVal,colNames);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  //Auto resize των στηλών του πίνακα για να απεικονίζονται όλα τα δεδομένα
        table.setPreferredScrollableViewportSize(new Dimension(1000, 700)); //οι διαστάσεις του πίνακα

        scrollPane = new JScrollPane(table); //μας βοηθάει να κάνει scroll όταν δεν μπορούν να εμγανιστούν στην οθόνη όλα τα δεδομένα του table

        panel.add(scrollPane);
        frame.add(panel);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό
    }
}

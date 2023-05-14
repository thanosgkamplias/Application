import javax.swing.*;
import java.awt.*;

//Κλάση για την εμφάνιση των συνολικών εσόδων της εταιρίας για συγκεκριμένο έτος μέσω γραφικής διεπαφής
public class CompIncomeWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    Company company; //περέχει όλα τα δεδομένα του object company

    CompIncomeWindow(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
        frame.setSize(1080,720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος
        panel = new JPanel(); //Δημιουργία νέου JPanel

        //Πίνακας που έχει τους τίτλους των πεδίων της κλάσης ProjectDetail
        String [] colNames = {"Year","Annual Company Income"};

        //Δημιουργία δισδιάστατου πίνακα που θα χρησιμοποιηθεί για την απεικόνιση των δεδομένων της ArrayList <ProjectDetail>
        String [][] dataVal = new String [3][2];
        dataVal[0][0] = "2018";
        dataVal[0][1] = String.valueOf(c.calculateAnnualCompanyIncome(2018));
        dataVal[1][0] = "2019";
        dataVal[1][1] = String.valueOf(c.calculateAnnualCompanyIncome(2019));
        dataVal[2][0] = "2020";
        dataVal[2][1] = String.valueOf(c.calculateAnnualCompanyIncome(2020));

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

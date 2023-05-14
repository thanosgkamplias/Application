import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//κλάση για την εμφάνιση παραθύρων που σχετίζονται με τα στοιχεία μισθοδοσίας και των εσόδων και εξόδων της εταιρίας
public class LaunchPage4 implements ActionListener{
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    // Δημιουργία των 3 κουμπιών
    //JButton button41 = new JButton("Print monthly salary for employee");
    JButton button42 = new JButton("Print annual company income");
    JButton button43 = new JButton("Print annual company expenses");

    Company company; //περέχει όλα τα δεδομένα του object company

    LaunchPage4(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        //Δημιουργία Panel για το Button41
       // button41.setBounds(100,160,200,40);
       // button41.setFocusable(false);
        //button41.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button42
        button42.setBounds(100,160,200,40);
        button42.setFocusable(false);
        button42.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button43
        button43.setBounds(100,160,200,40);
        button43.setFocusable(false);
        button43.addActionListener(this); //συνδεση του button με το Action Listener

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(420,420); //ορίζουμε το μέγεθος του παραθύρου σε 420 px πλάτος και 420 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        Container pane = frame.getContentPane(); //Δημιουργία υποδοχέα

        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        pane.setLayout(flo); // Σύνδεση διαχειριστή διάταξης με τον υποδοχέα

        //Σύνδεση των κουμπιών με τον υποδοχέα
       // pane.add(button41);
        pane.add(button42);

        pane.add(button43);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο
    }

    //Έλεγχος για το πιο button έχει πατηθεί και η φόρτωση του αντίστοιχου παραθύρου (JFrame)
    public void actionPerformed(ActionEvent e){
      //  if(e.getSource() == button41){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button41
      //      EmpSalaryWindow empSalWindow = new EmpSalaryWindow(company);
      //  }
         if (e.getSource() == button42){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button42
            CompIncomeWindow compIncWindow = new CompIncomeWindow(company);
        }
        else if (e.getSource() == button43){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button43
            CompExpensesWindow compExpensesWindow = new CompExpensesWindow(company);
        }
    }
}
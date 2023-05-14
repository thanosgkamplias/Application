import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//κλάση για την εμφάνιση παραθύρων που σχετίζονται με την ανάθεση και ενημέρωση στοιχείων των υπαλλήλων της εταιρίας
public class LaunchPage2 implements ActionListener {
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    // Δημιουργία των 4 κουμπιών
    JButton button21 = new JButton("Update employee data");
    JButton button22 = new JButton("Assign Employee to department");
    JButton button23 = new JButton("Assign Employee to Project");
    JButton button24 = new JButton("Assign Director to Department");

    Company company; //περέχει όλα τα δεδομένα του object company

    LaunchPage2(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        //Δημιουργία Panel για το Button21
        button21.setBounds(100,160,200,40);
        button21.setFocusable(false);
        button21.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button22
        button22.setBounds(100,160,200,40);
        button22.setFocusable(false);
        button22.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button23
        button23.setBounds(100,160,200,40);
        button23.setFocusable(false);
        button23.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button24
        button24.setBounds(100,160,200,40);
        button24.setFocusable(false);
        button24.addActionListener(this); //συνδεση του button με το Action Listener

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(420,420); //ορίζουμε το μέγεθος του παραθύρου σε 420 px πλάτος και 420 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        Container pane = frame.getContentPane(); //Δημιουργία υποδοχέα

        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        pane.setLayout(flo); // Σύνδεση διαχειριστή διάταξης με τον υποδοχέα

        //Σύνδεση των κουμπιών με τον υποδοχέα
        pane.add(button21);
        pane.add(button22);
        pane.add(button23);
        pane.add(button24);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο
    }

    //Έλεγχος για το πιο button έχει πατηθεί και η φόρτωση του αντίστοιχου παραθύρου (JFrame)
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button21){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button21
            UpdateEmployeeWindow empWindow = new UpdateEmployeeWindow(company);
        }
       else if (e.getSource() == button22){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button22
            AssignEmployeeToDept emplToDept = new AssignEmployeeToDept(company);
        }
        else if (e.getSource() == button23){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button23
            AssignEmployeeToProj emplToProj = new AssignEmployeeToProj(company);
        }
        else if (e.getSource() == button24){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button24
            AssignDirectorToDept drcToDept = new AssignDirectorToDept(company);
        }
    }
}
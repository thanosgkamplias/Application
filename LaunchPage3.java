import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//κλάση για την εμφάνιση παραθύρων που σχετίζονται με την εμφάνιση όλων των υπαλλήλων,των τμημάτων και των έργων της εταιρίας
public class LaunchPage3 implements ActionListener {
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    // Δημιουργία των 3 κουμπιών
    JButton button31 = new JButton("Print Employees");
    JButton button32 = new JButton("Print Departments");
    JButton button33 = new JButton("Print Projects");

    Company company; //περέχει όλα τα δεδομένα του object company

    LaunchPage3(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        //Δημιουργία Panel για το Button31
        button31.setBounds(100,160,200,40);
        button31.setFocusable(false);
        button31.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button32
        button32.setBounds(100,160,200,40);
        button32.setFocusable(false);
        button32.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button33
        button33.setBounds(100,160,200,40);
        button33.setFocusable(false);
        button33.addActionListener(this); //συνδεση του button με το Action Listener

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(420,420); //ορίζουμε το μέγεθος του παραθύρου σε 420 px πλάτος και 420 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        Container pane = frame.getContentPane(); //Δημιουργία υποδοχέα

        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        pane.setLayout(flo); // Σύνδεση διαχειριστή διάταξης με τον υποδοχέα

        //Σύνδεση των κουμπιών με τον υποδοχέα
        pane.add(button31);
        pane.add(button32);
        pane.add(button33);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο
    }

    //Έλεγχος για το πιο button έχει πατηθεί και η φόρτωση του αντίστοιχου παραθύρου (JFrame)
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button31){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button31
            PrintEmpWindow empWindow = new PrintEmpWindow(company);
        }
        else if (e.getSource() == button32){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button32
            PrintDeptWindow deptWindow = new PrintDeptWindow(company);
        }
        else if (e.getSource() == button33){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button33
            PrintProjWindow projWindow = new PrintProjWindow(company);
        }
    }
}

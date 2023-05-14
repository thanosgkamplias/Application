import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//κλάση για την εμφάνιση παραθύρων για την δημιουργία τμημάτων,υπαλλήλων και έργων
public class LaunchPage1 implements ActionListener {   //είναι για να χειρίζεται τα action events όπως τα button user clicks
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    // Δημιουργία των 3 κουμπιών
    JButton button11 = new JButton("Create departments");
    JButton button12 = new JButton("Create employees");
    JButton button13 = new JButton("Create projects");

    Company company; //περέχει όλα τα δεδομένα του object company

    LaunchPage1(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        //Δημιουργία Panel για το Button11
        button11.setBounds(100,160,200,40);
        button11.setFocusable(false);
        button11.addActionListener(this); //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button12
        button12.setBounds(100,160,200,40);
        button12.setFocusable(false);
        button12.addActionListener(this);  //συνδεση του button με το Action Listener

        //Δημιουργία Panel για το Button13
        button13.setBounds(100,160,200,40);
        button13.setFocusable(false);
        button13.addActionListener(this); //συνδεση του button με το Action Listener

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(420,420); //ορίζουμε το μέγεθος του παραθύρου σε 420 px πλάτος και 420 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        Container pane = frame.getContentPane(); //Δημιουργία υποδοχέα

        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        pane.setLayout(flo); // Σύνδεση διαχειριστή διάταξης με τον υποδοχέα

        //Σύνδεση των κουμπιών με τον υποδοχέα
        pane.add(button11);
        pane.add(button12);
        pane.add(button13);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο
    }

    //Έλεγχος για το πιο button έχει πατηθεί και η φόρτωση του αντίστοιχου παραθύρου (JFrame)
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button11){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button11
            DepartmentWindow deptWindow = new DepartmentWindow(company);
        }
        else if (e.getSource() == button12){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button12
            EmployeeWindow empWindow = new EmployeeWindow(company);
        }
        else if (e.getSource() == button13){  //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button13
            ProjectWindow projWindow = new ProjectWindow(company);
        }
    }
}


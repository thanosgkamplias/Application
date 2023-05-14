import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Κλάση για την δημιουργία παραθύρου που περιλαμβάνει την δημιουργία τμήμάτων μέσω γραφικής διεπαφής
public class DepartmentWindow {
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    private JPanel row1,row2,row3,row4;
    // Δημιουργία ετικετών
    private JLabel label1;
    private JLabel label2;
    //JTextField, είναι ένα component το οποίο μας επιτρέπει να γράψουμε σε μία γραμμή κειμένου
    private JTextField name1;
    private JTextField name2;

    // Δημιουργία των 3 κουμπιών
    JButton jbtn_save = new JButton("Save Department");
    JButton jbtn_new = new JButton("New Department");
    JButton jbtn_print = new JButton("Print Departments to Console");

    Company company; //περέχει όλα τα δεδομένα του object company

    DepartmentWindow(Company c){ //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(1080,720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        row1 = new JPanel();
        label1 = new JLabel("Insert the name of the department: ", JLabel.RIGHT);
        name1 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row2 = new JPanel();
        label2 = new JLabel("Insert the description of the department: ", JLabel.RIGHT);
        name2 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        //Δημιουργία Panel για το Button jbtn_save
        row3 = new JPanel();
        jbtn_save.setBounds(100,160,200,40);
        jbtn_save.setFocusable(false);

        //καθοριμός του κώδικα που θα εκτελεστεί όταν θα πατηθεί το button και μέσω της Action Performed
        jbtn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                company.addNewDepartment(name1.getText(),name2.getText());
            }
        });

        //Δημιουργία Panel για το Button jbtn_new
        jbtn_new.setBounds(100,160,200,40);
        jbtn_new.setFocusable(false);
        jbtn_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                name1.setText("");
                name2.setText("");
            }
        });

        //Δημιουργία Panel για το Button jbtn_print
        jbtn_print.setBounds(100,160,200,40);
        jbtn_print.setFocusable(false);
        jbtn_print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                company.printAllDepartments();
            }
        });

        Container pane = frame.getContentPane(); // Δημιουργία υποδοχέα

        // Ο grid layout manager παρέχει ευελιξία στην τοποθέτηση components.
        // Δημιουργείτε o διαχειριστής τοποθέτησης δίνοντας το πλήθος των
        // γραμμών και των στηλών. Τα components θα γεμίσουν τα κελιά που
        // ορίζει ο διαχειριστής.
        GridLayout layout = new GridLayout(3,2);
        pane.setLayout(layout);
        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        //Καθορισμός του layout για την εμφάνιση των labels και των text fields
        row1.setLayout(flo); //1η Σειρά
        row1.add(label1);
        row1.add(name1);
        pane.add(row1);

        row2.setLayout(flo); //2η Σειρά
        row2.add(label2);
        row2.add(name2);
        pane.add(row2);

        row3.setLayout(flo); //3η Σειρά
        row3.add(jbtn_save);
        row3.add(jbtn_new);
        row3.add(jbtn_print);
        pane.add(row3);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο

        // Γέμισμα του πλαισίου
        // Η μέθοδος pack() αυτόματα δίνει διαστάσεις στο JFrame ανάλογα με
        // τις διαστάσεις των components που βάζουμε μέσα του και ανάλογα την
        // θέση στην οποία βάζουμε καθένα από τα components
        frame.pack();
    }
}


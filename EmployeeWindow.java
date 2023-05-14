import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Κλάση για την δημιουργία παραθύρου που περιλαμβάνει την δημιουργία εργαζομένων μέσω γραφικής διεπαφής
public class EmployeeWindow {
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    private JPanel row1,row2,row3,row4,row5,row6,row7,row8,row9;

    // Δημιουργία ετικετών
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8;

    //JTextField, είναι ένα component το οποίο μας επιτρέπει να γράψουμε σε μία γραμμή κειμένου
    private JTextField name1,name2,name3,name4,name5,name6,name7,name8;

    // Δημιουργία των 3 κουμπιών
    JButton jbtn_save = new JButton("Save Employee");
    JButton jbtn_new = new JButton("New Employee");
    JButton jbtn_print = new JButton("Print Employees to Console");

    Company company; //περέχει όλα τα δεδομένα του object company

    EmployeeWindow(Company c) { //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(1080, 720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος
        frame.setLayout(null);
        frame.setVisible(true);  // Το πλαίσιο να είναι ορατό

        row1 = new JPanel();
        label1 = new JLabel("Insert the first name of the employee: ");
        name1 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row2 = new JPanel();
        label2 = new JLabel("Insert the last name of the employee: ");
        name2 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row3 = new JPanel();
        label3 = new JLabel("Insert the birth date: ");
        name3 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row4 = new JPanel();
        label4 = new JLabel("Insert the marital status: ");
        name4 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row5 = new JPanel();
        label5 = new JLabel("Insert the number of children: ");
        name5 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row6 = new JPanel();
        label6 = new JLabel("Insert the year of recruitment: ");
        name6 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row7 = new JPanel();
        label7 = new JLabel("Insert the year of recruitment: ");
        name7 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row8 = new JPanel();
        label8 = new JLabel("Insert the level of education: ");
        name8 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        //Δημιουργία Panel για το Button jbtn_save
        row9 = new JPanel();
        jbtn_save.setBounds(100,160,200,40);
        jbtn_save.setFocusable(false);

        //καθοριμός του κώδικα που θα εκτελεστεί όταν θα πατηθεί το button και μέσω της Action Performed
        jbtn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                company.addNewEmployee(name1.getText(),name2.getText(),new DateTime(name3.getText()),name4.getText(),name5.getColumns(),name6.getColumns(),name7.getText(),name8.getText());
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
                name3.setText("");
                name4.setText("");
                name5.setText("");
                name6.setText("");
                name7.setText("");
                name8.setText("");
            }
        });

        //Δημιουργία Panel για το Button jbtn_print
        jbtn_print.setBounds(100,160,200,40);
        jbtn_print.setFocusable(false);
        jbtn_print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                company.printAllEmployees();
            }
        });

        Container pane = frame.getContentPane(); // Δημιουργία υποδοχέα

        // Ο grid layout manager παρέχει ευελιξία στην τοποθέτηση components.
        // Δημιουργείτε o διαχειριστής τοποθέτησης δίνοντας το πλήθος των
        // γραμμών και των στηλών. Τα components θα γεμίσουν τα κελιά που
        // ορίζει ο διαχειριστής.
        GridLayout layout = new GridLayout(9,2);
        pane.setLayout(layout);
        FlowLayout flo = new FlowLayout();  // Δημιουργία διαχειριστή διάταξης

        //Καθορισμός του layout για την εμφάνιση των labels και των text fields
        row1.setLayout(flo); //1η σειρά
        row1.add(label1);
        row1.add(name1);
        pane.add(row1);

        row2.setLayout(flo); //2η σειρά
        row2.add(label2);
        row2.add(name2);
        pane.add(row2);

        row3.setLayout(flo); //3η σειρά
        row3.add(label3);
        row3.add(name3);
        pane.add(row3);

        row4.setLayout(flo); //4η σειρά
        row4.add(label4);
        row4.add(name4);
        pane.add(row4);

        row5.setLayout(flo); //5η σειρά
        row5.add(label5);
        row5.add(name5);
        pane.add(row5);

        row6.setLayout(flo); //6η σειρά
        row6.add(label6);
        row6.add(name6);
        pane.add(row6);

        row7.setLayout(flo); //7η σειρά
        row7.add(label7);
        row7.add(name7);
        pane.add(row7);

        row8.setLayout(flo); //8η σειρά
        row8.add(label8);
        row8.add(name8);
        pane.add(row8);

        row9.setLayout(flo); //9η σειρά
        row9.add(jbtn_save);
        row9.add(jbtn_new);
        row9.add(jbtn_print);
        pane.add(row9);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο

        // Γέμισμα του πλαισίου
        // Η μέθοδος pack() αυτόματα δίνει διαστάσεις στο JFrame ανάλογα με
        // τις διαστάσεις των components που βάζουμε μέσα του και ανάλογα την
        // θέση στην οποία βάζουμε καθένα από τα components
        frame.pack();
    }
}

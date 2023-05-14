import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//(κύρια) Κλάση για την υλοποίηση της γραφικής διεπαφής
public class Gui implements ActionListener {
    private JPanel row1,row2,row3,row4;
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου

    // Δημιουργία των 5 κουμπιών
    JButton button1 = new JButton("Create departments, employees and projects");
    JButton button2 = new JButton("Import and update data");
    JButton button3 = new JButton("Print departments, employees and projects");
    JButton button4 = new JButton("Print income and expenses of the company");
    Company company = new Company("Corporaze Company");

    //Constructor
    public Gui() {
        company.loadAllFiles();

        //Πρόσθεση ποσού (έξοδο) σε κάποιο απο τα Projects
        company.addNewExpenseToProject("Aegean Motorway", "iron", 3875.64, new DateTime(2019,4,13));
        company.addNewExpenseToProject("AEL FC ARENA", "plastic seat", 1875.32, new DateTime(2018,2,2));
        company.addNewExpenseToProject("Aegean Motorway", "tar", 6500.07, new DateTime(2020,2,8));

        //Πρόσθεση ποσού (έσοδο) σε κάποιο απο τα Projects
        company.addNewIncomeToProject("Aegean Motorway", "Payments from E1 company", 8500, new DateTime(2019, 8, 19));
        company.addNewIncomeToProject("AEL FC ARENA", "Payments from A4 company", 16000, new DateTime(2018,2,8));
        company.addNewIncomeToProject("Aegean Motorway", "Payments from B94 company", 6800, new DateTime(2020,5,8));
        company.addNewIncomeToProject("AEL FC ARENA", "Payments from D873 company", 21000, new DateTime(2020,2,8));

        frame.setSize(1080, 720); //ορίζουμε το μέγεθος του παραθύρου σε 1080 px πλάτος και 720 px το ύψος

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Κλείνει η εφαρμογή όταν κάνουμε κλικ στο κουμπί «Κλείσιμο» της γραμμής τίτλου

        frame.setVisible(true); // Το πλαίσιο να είναι ορατό

        Container pane = frame.getContentPane(); //Δημιουργία υποδοχέα

        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        pane.setLayout(flo); // Σύνδεση διαχειριστή διάταξης με τον υποδοχέα

        //Δημιουργία Panel για το Button1
        row1 = new JPanel();
        button1.setBounds(300,480,600,120);
        button1.setFocusable(false);
        button1.addActionListener(this);

        //Δημιουργία Panel για το Button2
        row2 = new JPanel();
        button2.setBounds(100,160,200,40);
        button2.setFocusable(false);
        button2.addActionListener(this);

        //Δημιουργία Panel για το Button3
        row3 = new JPanel();
        button3.setBounds(100,160,200,40);
        button3.setFocusable(false);
        button3.addActionListener(this);

        //Δημιουργία Panel για το Button4
        row4 = new JPanel();
        button4.setBounds(100,160,200,40);
        button4.setFocusable(false);
        button4.addActionListener(this);

        // Πρώτη γραμμή
        row1.setLayout(flo);
        row1.add(button1);
        pane.add(row1);

        // Δεύτερη γραμμή
        row2.setLayout(flo);
        row2.add(button2);
        pane.add(row2);

        // Τρίτη γραμμή
        row3.setLayout(flo);
        row3.add(button3);
        pane.add(row3);

        // Τέταρτη γραμμή
        row4.setLayout(flo);
        row4.add(button4);
        pane.add(row4);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο
    }

    //Έλεγχος για το πιο button έχει πατηθεί και η φόρτωση του αντίστοιχου παραθύρου (JFrame)
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){    //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button1
            LaunchPage1 p1 = new LaunchPage1(company);
        }
        else if(e.getSource() == button2){     //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button2
            LaunchPage2 p2 = new LaunchPage2(company);
        }
        else if(e.getSource() == button3){     //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button3
            LaunchPage3 p3 = new LaunchPage3(company);
        }
        else if(e.getSource() == button4){     //e.getSource(), το όνομα του button που έχει πατηθεί να είναι το button4
            LaunchPage4 p4 = new LaunchPage4(company);
        }
    }
}


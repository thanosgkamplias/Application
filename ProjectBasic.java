//κλάση ProjectBasic που περιλαμβάνει μόνο τις βασικές πληροφορίες ενός Project - έργου (Όνομα Project)
public class ProjectBasic {
    // Δήλωση μεταβλητών (Όνομα Project)
    private String projectName;   // ονομασία του Project

    //Constructor
    public ProjectBasic(String projectName){
        this.projectName = projectName;
    }

    //Μέθοδος 'setProjectName' η οποία ορίζει την τιμή της μεταβλητής projectName
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    //Μέθοδος 'getProjectName()' η οποία επιστρέφει την μεταβλητή projectName
    public String getProjectName(){
        return projectName;  //επιστρέφει το όνομα του εργαζομένου
    }
}


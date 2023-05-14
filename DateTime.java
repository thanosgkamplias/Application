// Κλάση DateTime για την δημιουργία ημερομηνιών
public class DateTime {

    // Δήλωση μεταβλητών
    private int year;
    private int month;
    private int day;

    //Constructor
    public DateTime(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateTime(String dtStr){
       String data[] = dtStr.split("-");
        this.year = Integer.parseInt(data[2]);
        this.month = Integer.parseInt(data[1]);
        this.day = Integer.parseInt(data[0]);
    }

    //Default Constructor
    public DateTime(){
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    //Δημιουργία αντικειμένων DateTime
    public DateTime(DateTime dt){
        this.year = dt.getYear();
        this.month = dt.getMonth();
        this.day = dt.getDays();
    }

    private String convertNumberToDoubleDigit(int num){
        if(num < 10){
            return "0" + String.valueOf(num);
        }
        else{
            return String.valueOf(num);
        }
    }

    public String toString(){
        return convertNumberToDoubleDigit(this.day) + "-" + convertNumberToDoubleDigit(this.month) + "-" + convertNumberToDoubleDigit(this.year);
    }

    //Μέθοδος 'setYear' η οποία ορίζει την τιμή της μεταβλητής year
    public void setYear(int year){
        this.year = year;
    }

    //Μέθοδος 'setMonth' η οποία ορίζει την τιμή της μεταβλητής month
    public void setMonth(int month){
        this.month = month;
    }

    //Μέθοδος 'setDays' η οποία ορίζει την τιμή της μεταβλητής day
    public void setDays(int days){
        this.day = days;
    }

    //Μέθοδος 'getYear()' η οποία επιστρέφει την μεταβλητή year
    public int getYear(){
        return year;
    }

    //Μέθοδος 'getMonth()' η οποία επιστρέφει την μεταβλητή month
    public int getMonth(){
        return month;
    }

    //Μέθοδος 'getDays()' η οποία επιστρέφει την μεταβλητή day
    public int getDays(){
        return day;
    }

    //Μέθοδος η οποία ελέγχει αν
    public Boolean isDateFilled(){
        //ελέγχει αν το πεδίο year περιέχει την τιμή 0. Αν την περιέχει επιστρέφει false αλλιώς επιστρέφει true
        if (this.year == 0)
            return false;  //επιστρέφει false (0)

        return true;  //επιστρέφει true (1)
    }
}

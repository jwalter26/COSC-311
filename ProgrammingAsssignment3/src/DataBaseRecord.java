public class DataBaseRecord
 {
    private String fName;
    private String lName;
    private String id;

    public DataBaseRecord (String lName , String fName , String id) { // main constructor for a new database record
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    public String toString() {  // Prints the record's three fields
        return lName + " " + fName + " " + " " + id;
    }

    public String getfName() { // returns the student's first name
        return fName;
    }

    public String getlName() { // returns the student's last name
        return lName;
    }

    public String getid() { // returns the student's ID number
        return id;
    }
}

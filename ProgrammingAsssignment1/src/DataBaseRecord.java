public class DataBaseRecord
 {
    public String fName;
    public String lName;
    public String id;

    public DataBaseRecord(){    // Main constructor for a new database record
        fName = "fName";
        lName = "lName";
        id = "53";
    }

    public DataBaseRecord (String last , String first , String StuId) {
        fName = first;
        lName = last;
        id = StuId;
    }

    public String toString() {  // Prints the record's three fields
        return lName + " " + fName + " " + " " + id;
    }
}

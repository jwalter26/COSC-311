public class DataBaseRecord
 {
    private String fName;
    private String lName;
    private String id;

    public DataBaseRecord (String lName , String fName , String id) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    public String toString() {  // Prints the record's three fields
        return lName + " " + fName + " " + " " + id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getid() {
        return id;
    }
}

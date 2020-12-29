import java.util.*;
import java.io.*;
public class DataBase {
    Scanner in = new Scanner(System.in);
    private int next;
    private DataBaseRecord [] students;
    IndexArray SortById = new IndexArray();
    IndexArray SortByfName = new IndexArray();
    IndexArray SortBylName = new IndexArray();
    private String newlName;
    private  String newfName;
    private String newID;

    public DataBase() {                 // Main database constructor
        try {                           // Try-catch to get around FileNotFoundException
            File studentData = new File("J:\\Programming\\Java\\COSC 311\\ProgrammingAssignment1\\ProgrammingAsssignment1\\src\\dataset.txt");
            Scanner fin = new Scanner(studentData);
            next = 0;
            students = new DataBaseRecord[100];
            while (fin.hasNext()){      // Loop to read in the data from dataset.txt and populate the arrays
                newlName = fin.next();
                newfName = fin.next();
                newID = fin.next();
                findDuplicateAndInsert();
            }
            fin.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
       
    }

    public void addIt() {       // Accepts user input to add new records to the database
        System.out.println("Enter the student's last name, first name, and ID number, in that order: ");
        newlName = in.next();
        newfName = in.next();
        newID = in.next();
        findDuplicateAndInsert();
    }

    public void findIt() {      // Looks for and returns a record based on user input of an ID
        System.out.println("Enter a student ID to look up: ");
        String searchid = in.next();
        int find = SortById.search(searchid);
        if (find != -1)
            System.out.println(students[SortById.data[find].index]);
        else System.out.println("ID not found");
    }

    public void deleteIt() {    // Deletes a record from the database
        System.out.println("Enter the ID number of the student you wish to delete: ");
        String delid = in.next();
        int del1 = SortById.delete(delid);
        int del2 = SortByfName.delete(delid);
        int del3 = SortBylName.delete(delid);
        if (del1+del2+del3 == 3)
            System.out.println("Deleted");
        else System.out.println("ID not found");
    }

    public void ListByIDAscending() {       // Lists records in ascending order by ID
       print(SortById);
       System.out.println();
    }
    
    public void ListByFirstAscending() {    // Lists records in ascending order by first name   
       print(SortByfName);
       System.out.println();
    }

    public void ListByLastAscending() {     // Lists records in ascending order by last name
       print(SortBylName);
       System.out.println();
    }

    public void ListByIDDescending() {      // Lists records in descending order by ID
        printBackwards(SortById);
        System.out.println();
    }

    public void ListByFirstDescending() {   // Lists records in descending order by first name
        printBackwards(SortByfName);
        System.out.println();
    }

    public void ListByLastDescending() {    // Lists records in descending order by last name
        printBackwards(SortBylName);
        System.out.println();
    }

    public void print(IndexArray a) {       // Prints data from the beginning of the array
        IndexRecord s;
        a.setIteratorBegin();
        for(s=a.getIterator(); s!=null;s=a.getIteratorNext())
             System.out.println(students[s.index]);
     }

    public void printBackwards(IndexArray a) {  // Prints data in from the end of the array
        IndexRecord s; 
        a.setIteratorEnd();
        for(s=a.getIterator(); s!=null;s=a.getIteratorPrev())
            System.out.println(students[s.index]);
    }

    public void findDuplicateAndInsert(){       // Looks for a duplicate ID and skips the new record if true. Otherwise, the new record is added to the database.
        if (SortById.search(newID) == -1) {
            students[next] = new DataBaseRecord(newlName,newfName,newID);
            SortById.insert(new IndexRecord(students[next].id, next));
            SortByfName.insert(new IndexRecord(students[next].fName, next));
            SortBylName.insert(new IndexRecord(students[next].lName, next));
            next++;
        }
        else System.out.println("Warning: ID already in use");
    }
}



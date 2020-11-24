import java.util.*;
import java.io.*;
public class DataBase {
    Scanner in = new Scanner(System.in);
    private int next;
    public DataBaseRecord [] students;
    Tree SortById = new Tree();
    Tree SortByfName = new Tree();
    Tree SortBylName = new Tree();
    private String newlName;
    private String newfName;
    private String newID;

    public DataBase() {                 // Main database constructor
        try {                           // Try-catch to get around FileNotFoundException
            File studentData = new File("C:\\Users\\pc\\Documents\\GitHub\\Jesses-Projects\\ProgrammingAsssignment3\\src\\dataset.txt");
            Scanner fin = new Scanner(studentData);
            next = 0;
            students = new DataBaseRecord[100];
            while (fin.hasNext()){      // Loop to read in the data from dataset.txt and populate the arrays
                newlName = fin.next();
                newfName = fin.next();
                newID = fin.next();
                findDuplicatesAndPopulate();
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
        findDuplicatesAndPopulate();
    }

    public void findIt() {      // Looks for and returns a record based on user input of an ID
        System.out.println("Enter a student ID to look up: ");
        String searchid = in.next();
        int find = SortById.search(searchid);
        if (find != -1)
            System.out.println(students[find]);
        else System.out.println("ID not found");
    }

    public void deleteIt() {    // Deletes a record from the database
        System.out.println("Enter the ID number of the student you wish to delete: ");
        String delid = in.next();
        int del = SortById.search(delid);
        if (del == -1)
            System.out.println("ID not found");
        else {
            SortById.delete(del);
            SortByfName.delete(del);
            SortBylName.delete(del);
            System.out.println("Deleted");
        }
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

    public void print(Tree a) {       // Prints data from the beginning of the list
        a.inOrder(a.getRoot(), students);
    }
    public void printBackwards(Tree a) {  // Prints data in from the end of the list
        a.inOrderBackwards(a.getRoot(), students);
    }

    public boolean findDuplicates(String id){   // Looks for a duplicate ID and skips the new record if true
        if (SortById.search(id) != -1)
            return true;
        else return false;
    }

    public void populate() {  // populates the database array and the sorted linked lists for each field
        students[next] = new DataBaseRecord(newlName,newfName,newID);
        SortById.insert(new Node(newID, next));
        SortByfName.insert(new Node(newfName, next));
        SortBylName.insert(new Node(newlName, next));
        next++;
    }
    
    public void findDuplicatesAndPopulate() { // combines populate and findDuplicates for cleaner code
        if (findDuplicates(newID))
            System.out.println("Warning: "+ newID + " already in use. Record will be discarded.");
        else populate();
    }
}



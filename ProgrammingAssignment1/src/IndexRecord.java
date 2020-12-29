public class IndexRecord {
	public String field;
	public int index;
	
	public IndexRecord(String studentData, int listIndex) {		// Constructor for a new index record
		field = new String(studentData);
		index = listIndex;
	}
}
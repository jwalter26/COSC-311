public class IndexArray {
    private int next;
    public IndexRecord[] data;
    private int nElems;
    private int iter;

    public IndexArray() {   // Main constuctor for a new IndexArray
        next = 0;
        nElems = 100;
        data = new IndexRecord[nElems];
    }

    public IndexArray(int nElems) {
        next = 0;
        data = new IndexRecord[nElems];
    }

    public void insert(IndexRecord recordValue) {   // Adds a new index record in its correct position in the array
        int j;
        for (j = next-1 ; j >=0 ; j--) {
            if (data[j].field.compareTo(recordValue.field) < 0) break;
            data[j+1] = data[j];
        }
        data[j+1] = recordValue;
        next++;
    }

    public int search(String searchElem) {          // Locates an index record; returns the location if value is found, -1 if not
        int hi = next-1;
        int lo = 0;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (data[mid].field.equals(searchElem)) break;
            if (data[mid].field.compareTo(searchElem) < 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        if (mid == 0) return -1;
        else if (data[mid].field.equals(searchElem)) return mid;
        else return -1;
    }

    public int linearSearch(int searchIndex) {
        int i;
        for (i = 0 ; i < next ; i++) {
            if (data[i].index == searchIndex) break;
        }
        if (i == 0) return -1;
        if (data[i].index == searchIndex) return i;
        else return -1;
    }

    public int delete(String delElem) {   // Deletes an index record by calling search to find its location, and then wiping the value and shifting data upwards in the array
        int index = search(delElem);
        if (index != -1) {
            if (index >= 0) {
                for (index = index + 1 ; index < next ; index++) {
                    data[index - 1] = data[index];
                }
                next--;
                return 1;
            }  
        }
        return 0;
    }

    public void setIteratorBegin() {            // Sets iterator location to the beginning of the array
        iter = (next > 0 ? 0 : -1);
    }

    public void setIteratorEnd() {              // Sets iterator location to the end of the array
        iter = (next > 0 ? next - 1 : -1);
    }

    public IndexRecord getIterator() {          // Returns iterator location in the array
        return (iter == -1 ? null : data[iter]);
}

    public IndexRecord getIteratorNext() {      // Returns the next location from the current
        iter = (iter == next - 1 ? -1: iter + 1);
        return (iter == -1 ? null : data[iter]);
    }

    public IndexRecord getIteratorPrev() {      // Returns the previous location from the current
        iter = (iter == 0 ? -1 : iter - 1);
        return (iter == -1 ? null : data[iter]);
    }  
}



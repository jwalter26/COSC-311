import java.io.PrintWriter;

public class QuickSort {
    public int [] arr;
    private int sz;

    public QuickSort(int size) {
        arr = new int[size];
        sz = 0;
    }

    public void insert(int elem){
        arr[sz] = elem;
        sz++;
    }

    public void display(PrintWriter p){
        for(int j=0; j < sz; j++) // for each element,
            p.println(arr[j] + " "); // display it
    }

    /*public void quickSort(){
        recQuickSort(0, sz - 1);
    }

    public void recQuickSort(int left, int right){
        if (right-left <= 0) return;
        else {
            long pivot = arr[right];
            int partition = partitionIt(left,right,pivot);
            recQuickSort(left,partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (arr[++leftPtr] < pivot) ;
            while (rightPtr > 0 && arr[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr) break;
            else swap(leftPtr, rightPtr);
        }
        swap(leftPtr, rightPtr);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }*/

    private int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high]; 
  
        // index of smaller element 
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 
  
        return i + 1; 
    } 
  
    /* A[] --> Array to be sorted,  
   l  --> Starting index,  
   h  --> Ending index */
    public void quickSortIterative(int arr[], int l, int h) 
    { 
        // Create an auxiliary stack 
        int[] stack = new int[h - l + 1]; 
  
        // initialize top of stack 
        int top = -1; 
  
        // push initial values of l and h to stack 
        stack[++top] = l; 
        stack[++top] = h; 
  
        // Keep popping from stack while is not empty 
        while (top >= 0) { 
            // Pop h and l 
            h = stack[top--]; 
            l = stack[top--]; 
  
            // Set pivot element at its correct position 
            // in sorted array 
            int p = partition(arr, l, h); 
  
            // If there are elements on left side of pivot, 
            // then push left side to stack 
            if (p - 1 > l) { 
                stack[++top] = l; 
                stack[++top] = p - 1; 
            } 
  
            // If there are elements on right side of pivot, 
            // then push right side to stack 
            if (p + 1 < h) { 
                stack[++top] = p + 1; 
                stack[++top] = h; 
            } 
        } 
    } 

    public int getSize() {
        return sz;
    }
}

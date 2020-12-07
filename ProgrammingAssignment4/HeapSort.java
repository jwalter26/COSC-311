import java.io.PrintWriter;


public class HeapSort {
    public int [] arr;
    private int sz;

    public HeapSort(int size) {
        arr = new int[size];
        sz = 0;
    }

    public void insertAt(int elem){ 
        arr[sz] = elem; 
        sz++;
    }
    
    public void sort()
    {
        int n = sz;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        for (int i = n - 1; i > 0; i--) {
           
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
           
            heapify(arr, i, 0);
        }
    }
 
   
    void heapify(int arr[], int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
       
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
       
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
           
            heapify(arr, n, largest);
        }
    }
 
   
    public void display(PrintWriter p)
    {
        for (int i = 0; i < sz; ++i)
            p.println(arr[i]);
        p.close();
    }
}
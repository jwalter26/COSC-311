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
        for(int j=0; j < sz; j++) {
            p.println(arr[j]); 
            
        }
        p.close();
    }

    private int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high]; 
  
       
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
            
            
            if (arr[j] <= pivot) { 
                i++; 
  
                
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 
  
        return i + 1; 
    } 
  
   
    public void quickSortIterative(int arr[], int l, int h) 
    { 
        
        int[] stack = new int[h - l + 1]; 
  
        int top = -1; 
  

        stack[++top] = l; 
        stack[++top] = h; 
  

        while (top >= 0) { 
            
            h = stack[top--]; 
            l = stack[top--]; 
  
           
            int p = partition(arr, l, h); 
  
           
            if (p - 1 > l) { 
                stack[++top] = l; 
                stack[++top] = p - 1; 
            } 
  
           
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

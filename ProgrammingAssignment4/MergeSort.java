import java.io.PrintWriter;

public class MergeSort {
    private long [] arr;
    private int sz;

    public MergeSort(int max) {
        arr = new long[max];
        sz = 0;
    }

    public void insert(long value) {
        arr[sz] = value; 
        sz++;
    }

    public void display(PrintWriter p) {
        for(int j=0; j<sz; j++) {
            p.println(arr[j]);
        }
        p.close();
    }

    public void mergeSort() { 
        long[] workSpace = new long[sz];
        recMergeSort(workSpace, 0, sz-1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)
            return;
        else { 
            int mid = (lowerBound+upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid+1, upperBound);
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    } 

    private void merge(long[] workSpace, int lowPtr,int highPtr, int upperBound)
    {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // # of items
        while(lowPtr <= mid && highPtr <= upperBound)
            if(arr[lowPtr] < arr[highPtr] )
                workSpace[j++] = arr[lowPtr++];
            else
                workSpace[j++] = arr[highPtr++];
        while(lowPtr <= mid)
            workSpace[j++] = arr[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = arr[highPtr++];
        for(j=0; j<n; j++)
            arr[lowerBound+j] = workSpace[j];
    } 


    public int getSize() {
        return sz;
    }
}
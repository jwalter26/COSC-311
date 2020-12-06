import jdk.nashorn.api.tree.WhileLoopTree;

public class QuickSort {
    private long [] arr;
    private int sz;

    public QuickSort(int size) {
        arr = new long[size];
        sz = 0;
    }

    public void insert(long elem){
        arr[sz] = elem;
        sz++;
    }

    public void display(){
        for(int j=0; j < sz; j++) // for each element,
        System.out.print(arr[j] + " "); // display it
        System.out.println("");
    }

    public void quickSort(){
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

    public void partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (arr[++leftPtr] < pivot) ;
            sort
        }
    }
}

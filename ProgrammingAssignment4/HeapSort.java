public class HeapSort {
    private Node[] arr;
    private int size;
    private int currsize;

    public HeapSort(int size) {
        this.size = size;
        currsize = 0;
        arr = new Node[size];
    }

    public Node remove() {
        Node root = arr[0];
        arr[0] = arr[--currsize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index){
        int largerChild;
        Node top = arr[index];
        while(index < currsize/2) {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;
            
            if(rightChild < currsize && arr[leftChild].getData() < arr[rightChild].getData())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if(top.getData() >= arr[largerChild].getData()) break;

            arr[index] = arr[largerChild];
            index = largerChild; 
        } 
        arr[index] = top;
    }

    public void displayArray() {
        for(int j=0; j<size; j++)
        System.out.print(arr[j].getData() + " ");
        System.out.println("");
    }

    public void insertAt(int index, Node newNode) { 
        arr[index] = newNode; 
    }

    public void incrementSize() { 
        currsize++; 
    }
}
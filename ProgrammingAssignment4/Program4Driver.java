import java.util.*;
import java.io.*;
public class Program4Driver {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        //System.out.println("Enter an input file for random data: ");
        //Scanner rin = new Scanner(new File(in.nextLine()));
        Scanner rinMerge = new Scanner(new File("dataRandom.txt"));
        Scanner rinHeap = new Scanner(new File("dataRandom.txt"));
        Scanner rinQuick = new Scanner(new File("dataRandom.txt"));

        //System.out.println("Enter an input file for ascending data data: ");
        //Scanner ain = new Scanner(new File(in.nextLine()));
        Scanner ainMerge = new Scanner(new File("dataAscend.txt"));
        Scanner ainHeap = new Scanner(new File("dataAscend.txt"));
        Scanner ainQuick = new Scanner(new File("dataAscend.txt"));

        //System.out.println("Enter an input file for descending data: ");
        //Scanner din = new Scanner(new File(in.nextLine()));
        Scanner dinMerge = new Scanner(new File("dataDescend.txt"));
        Scanner dinHeap = new Scanner(new File("dataDescend.txt"));
        Scanner dinQuick = new Scanner(new File("dataDescend.txt"));

        System.out.println("Enter a filename prefix for the output files: ");
        String outPrefix = in.nextLine();
        PrintWriter outHR = new PrintWriter(new File(outPrefix + "HeapRandom.txt"));
        PrintWriter outQR = new PrintWriter(new File(outPrefix + "QuickRandom.txt"));
        PrintWriter outMR = new PrintWriter(new File(outPrefix + "MergeRandom.txt"));
        PrintWriter outHA = new PrintWriter(new File(outPrefix + "HeapAscend.txt"));
        PrintWriter outQA = new PrintWriter(new File(outPrefix + "QuickAscend.txt"));
        PrintWriter outMA = new PrintWriter(new File(outPrefix + "MergeAscend.txt"));
        PrintWriter outHD = new PrintWriter(new File(outPrefix + "HeapDescend.txt"));
        PrintWriter outQD = new PrintWriter(new File(outPrefix + "QuickDescend.txt"));
        PrintWriter outMD = new PrintWriter(new File(outPrefix + "MergeDescend.txt"));
        
        HeapSort heapA = new HeapSort(11000);
        HeapSort heapD = new HeapSort(11000);
        HeapSort heapR = new HeapSort(11000);
        MergeSort mergeA = new MergeSort(11000);
        MergeSort mergeD = new MergeSort(11000);
        MergeSort mergeR = new MergeSort(11000);
        QuickSort quickA = new QuickSort(11000);
        QuickSort quickD= new QuickSort(11000);
        QuickSort quickR = new QuickSort(11000);

        while (ainHeap.hasNextInt()) {
            int newElem = ainHeap.nextInt();
            heapA.insertAt(newElem);
        }
        
        while (dinHeap.hasNextInt()) {
            int newElem = dinHeap.nextInt();
            heapD.insertAt(newElem);
        }

        while (rinHeap.hasNextInt()) {
            int newElem = rinHeap.nextInt();
            heapR.insertAt(newElem);
        }

        while (ainMerge.hasNextInt()) {
            int newElem = ainMerge.nextInt();
            mergeA.insert(newElem);
            
        }

        while (dinMerge.hasNextInt()) {
            int newElem = dinMerge.nextInt();
            mergeD.insert(newElem);
            
        }

        while (rinMerge.hasNextInt()) {
            int newElem = rinMerge.nextInt();
            mergeR.insert(newElem);
            
        }

        while (ainQuick.hasNextInt()) {
            int newElem = ainQuick.nextInt();
            quickA.insert(newElem);
           
        }

        while (dinQuick.hasNextInt()) {
            int newElem = dinQuick.nextInt();
            quickD.insert(newElem);
            
        }

        while (rinQuick.hasNextInt()) {
            int newElem = rinQuick.nextInt();
            quickR.insert(newElem);
            
        }

        long startHA = System.nanoTime();
        heapA.sort();
        long endHA = System.nanoTime();
        heapA.display(outHA);
        System.out.println("Heap Ascending: " + (endHA - startHA) + " nanoseconds");

        long startHD = System.nanoTime();
        heapD.sort();
        long endHD = System.nanoTime();
        heapD.display(outHD);
        System.out.println("Heap Descending: " + (endHD - startHD) + " nanoseconds");

        long startHR = System.nanoTime();
        heapR.sort();
        long endHR = System.nanoTime();
        heapR.display(outHR);
        System.out.println("Heap Random: " + (endHR - startHR) + " nanoseconds");

        long startMA = System.nanoTime();
        mergeA.mergeSort();
        long endMA = System.nanoTime();
        mergeA.display(outMA);
        System.out.println("Merge Ascending: " + (endMA - startMA) + " nanoseconds");

        long startMD = System.nanoTime();
        mergeD.mergeSort();
        long endMD = System.nanoTime();
        mergeD.display(outMD);
        System.out.println("Merge Descending: " + (endMD - startMD) + " nanoseconds");

        long startMR = System.nanoTime();
        mergeR.mergeSort();
        long endMR = System.nanoTime();
        mergeR.display(outMR);
        System.out.println("Merge Random: " + (endMR - startMR) + " nanoseconds");

        long startQA = System.nanoTime();
        quickA.quickSortIterative(quickA.arr, 0 , quickA.getSize() - 1);
        long endQA = System.nanoTime();
        quickA.display(outQA);
        System.out.println("Quick Ascending: " + (endQA - startQA) + " nanoseconds");

        long startQD = System.nanoTime();
        quickD.quickSortIterative(quickD.arr, 0 , quickD.getSize() - 1);
        long endQD = System.nanoTime();
        quickD.display(outQD);
        System.out.println("Quick Descending: " + (endQD - startQD) + " nanoseconds");

        long startQR = System.nanoTime();
        quickR.quickSortIterative(quickR.arr, 0 , quickR.getSize() - 1);
        long endQR = System.nanoTime();
        quickR.display(outQR);
        System.out.println("Quick Random: " + (endQR - startQR) + " nanoseconds");
    }
}
/**
 * This class makes builds a heaps through bottom up insertion and then restores the maxheap property
 * it removes the top element and sorts it into its proper place.
 * 
 * @author (ben durao) 
 * @version (november 20, 2016)
 */
import java.util.*;

public class Heap
{
    private static int N; // number of elements in tree
    public static int comparisons, exchanges;
    
    public static void sort(int arr[])
    {       
        buildHeap(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
      
    public static void buildHeap(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
         
    public static void maxheap(int arr[], int i)
    { 
        int leftChild = 2*i;
        int rightChild = 2*i + 1;
        int max = i;
        if (leftChild <= N && arr[leftChild] > arr[i])
            max = leftChild;
        if (rightChild <= N && arr[rightChild] > arr[max])        
            max = rightChild;
        comparisons++;
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    
    public static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        exchanges++;
    }    
 
}

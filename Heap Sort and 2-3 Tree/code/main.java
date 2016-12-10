
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class main
{
    /* Main method */
    public static void main(String[] args) 
    {
        System.out.println("Heap Sort Test\n");
        
        Random random = new Random();
 
        int n = 2000;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        
        /* USE FOR REVERSE SORT 1999 > 0
        int index = 0;
        
        for (int i = 2000; i > 0; i--)
        {
            arr1[index] = i;//Math.abs(random.nextInt(100));
            index++;
        }
        */
       
       /* USE FOR SORTED ARRAY */
        for(int i=0;i<n;i++)
            arr1[i] = i;//Math.abs(random.nextInt(500)); /* USE FOR RANDOM ARRAY */
            
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);

        Heap heap = new Heap();
        Quick quick = new Quick();
        Shell shell = new Shell();

        for (int i = 0; i < n; i++)
            System.out.print(arr1[i]+" ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(arr2[i]+" ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(arr3[i]+" ");
        System.out.println();
        /* Call method sort */
        heap.sort(arr1);
        quick.sort(arr2);
        shell.shellSort(arr3);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");        
        for (int i = 0; i < n; i++)
            System.out.print(arr1[i]+" "); 
        System.out.println();
        System.out.println(heap.exchanges + " exchanges and " + heap.comparisons + " comparisons.");  
        for (int i = 0; i < n; i++)
            System.out.print(arr2[i]+" ");
        System.out.println();
        System.out.println(quick.exchanges + " exchanges and " + quick.comparisons + " comparisons.");  
        for (int i = 0; i < n; i++)
            System.out.print(arr3[i]+" ");
        System.out.println();
        System.out.println(shell.exchanges + " exchanges and " + shell.comparisons + " comparisons.");  
          
    }    
}

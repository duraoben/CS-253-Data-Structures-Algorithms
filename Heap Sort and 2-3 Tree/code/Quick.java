/**
 * Quick sort sorts by establishing a pivot point and making it so all elements to pivots left
 * are less than it and all elements to pivots right are greater than it recursively through the
 * array needed to be sorted.
 * @author (ben durao) 
 * @version (november 20, 2016)
 */
import java.util.*;

public class Quick
{

    public static int comparisons, exchanges;
    public static void sort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int arr[], int low, int high) 
    {
        int i = low, j = high;
        int temp;
        int pivot = arr[low];//arr[(low + high) / 2];
 
        /** partition **/
        while (i <= j) 
        {
            comparisons++;
            while (arr[i] < pivot)
            {
                i++;
                comparisons++;
            }
            while (arr[j] > pivot)
            {
                j--;
                comparisons++;
            }
            if (i <= j) 
            {
                /** swap **/
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                exchanges++;
                i++;
                j--;
            }
        }
 
        /** recursively sort lower half **/
        if (low < j)
            quickSort(arr, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(arr, i, high);
    }
   
}


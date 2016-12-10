/**
 * Shell sort is an advanced extension of insertion sort by making swaps at farther distances.
 * 
 * @author (ben durao) 
 * @version (november 20, 2016)
 */
import java.util.*;

public class Shell
{
    public static int N;
    public static int exchanges, comparisons;
 
    public static void shellSort(int sequence[]) 
    {
        int increment = sequence.length / 2;
        while (increment > 0) 
        {
            for (int i = increment; i < sequence.length; i++) 
            {
                int j = i;
                int temp = sequence[i];
                comparisons++;
                while (j >= increment && sequence[j - increment] > temp) 
                {
                    exchanges++;
                    sequence[j] = sequence[j - increment];
                    j = j - increment;
                    comparisons++;
                }
                sequence[j] = temp;
            }
            if (increment == 2)
                increment = 1;
            else
                increment *= (5.0 / 11);
 
        }
    }
 
    static void printSequence(int[] sorted_sequence) 
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

}

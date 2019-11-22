package chapter1.part4.low;

import java.util.Arrays;
/**
 * 1.4.10
 * 
 * @author mulw
 *
 */
public class MinKeyOfBinarySearch
{
    /**
     * 要求数组a是有序的
     * 
     * @param a
     * @param k
     * @return
     */
    public static int getMinKey(int[] a, int k)
    {
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        while(low <= high)
        {
            mid = (low+high)/2;
            if (k > a[mid]) low = mid + 1;
            else if (k < a[mid]) high = mid;
            else if (mid > 0 && a[mid-1] == k) high = mid; //因为有序，所以检查前一个元素
            else return mid;
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] test = {1,1,1,1,1,1,2,3,5,5,2,6,2,5,2};
        Arrays.sort(test);
        for (int i = 0; i < test.length; i++)
        {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        int i = MinKeyOfBinarySearch.getMinKey(test, 3);
        System.out.print(i);
    }
}

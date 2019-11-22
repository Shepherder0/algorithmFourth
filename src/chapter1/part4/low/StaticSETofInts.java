package chapter1.part4.low;

import java.util.Arrays;

/**
 * 1.4.11
 * @author mulw
 *
 */
public class StaticSETofInts
{
    private int[] a;
    private int count = 0;
    public StaticSETofInts(int[] keys)
    {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];
        Arrays.sort(a);
    }
    public boolean contains(int key)
    {
        return rank(key) != -1;
    }
    private int rank(int key)
    {
        int low = 0;
        int high = a.length - 1;
        while(low <= high)
        {
            count++;
            int mid = (low + high)/2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public int howMany()
    { return count;}
}

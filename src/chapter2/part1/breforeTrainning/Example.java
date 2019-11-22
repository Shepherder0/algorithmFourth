package chapter2.part1.breforeTrainning;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法的基本功能
 * @author mulw
 *
 */
@SuppressWarnings("rawtypes")
public class Example {
    
    public static void sort(Comparable[] a)
    {
        
    }
    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    
    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }
}

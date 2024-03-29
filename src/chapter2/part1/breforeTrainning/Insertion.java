package chapter2.part1.breforeTrainning;

/**
 * 插入排序
 * @author mulw
 *
 */
public class Insertion extends Example
{
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}

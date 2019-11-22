package chapter2.part1.breforeTrainning;

/**
 * 希尔算法
 * @author mulw
 *
 */
public class Shell extends Example
{
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1)
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j-j]); j -=h)
                {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
